/*
 * Copyright 2014 Jose Lopes
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.fec.openrq;


import net.fec.openrq.decoder.DataDecoder;
import net.fec.openrq.decoder.SourceBlockDecoder;
import RQLibrary.Partition;


/**
 * @author Jos&#233; Lopes &lt;jlopes&#064;lasige.di.fc.ul.pt&gt;
 * @author Ricardo Fonseca &lt;ricardof&#064;lasige.di.fc.ul.pt&gt;
 */
public final class ArrayDataDecoder implements DataDecoder {

    static ArrayDataDecoder newDecoder(FECParameters fecParams) {

        if (!fecParams.isValid()) {
            throw new IllegalArgumentException("invalid FEC parameters");
        }
        if (fecParams.dataLength() > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("maximum data length exceeded");
        }

        final byte[] array = new byte[(int)fecParams.dataLength()];
        return new ArrayDataDecoder(array, fecParams);
    }


    private final byte[] array;
    private final FECParameters fecParams;
    private final SourceBlockDecoder[] srcBlockDecoders;


    private ArrayDataDecoder(byte[] array, FECParameters fecParams) {

        this.array = array;
        this.fecParams = fecParams;
        this.srcBlockDecoders = partitionData(array, fecParams);
    }

    private static SourceBlockDecoder[] partitionData(
        byte[] array,
        FECParameters fecParams)
    {

        final int Kt = fecParams.totalSymbols();
        final int Z = fecParams.numberOfSourceBlocks();

        // (KL, KS, ZL, ZS) = Partition[Kt, Z]
        final Partition KZ = new Partition(Kt, Z);
        final int KL = KZ.get(1);
        final int KS = KZ.get(2);
        final int ZL = KZ.get(3);

        // partitioned source blocks
        final SourceBlockDecoder[] srcBlockDecoders = new ArraySourceBlockDecoder[Z];

        /*
         * The object MUST be partitioned into Z = ZL + ZS contiguous source blocks.
         * Each source block contains a region of the data array, except the last source block
         * which may also contain extra padding.
         */

        // source block number (index)
        int sbn;

        for (sbn = 0; sbn < ZL; sbn++) { // first ZL
            srcBlockDecoders[sbn] = ArraySourceBlockDecoder.newDecoder(array, 0, fecParams, KL, sbn);
        }

        for (; sbn < Z; sbn++) {// last ZS
            srcBlockDecoders[sbn] = ArraySourceBlockDecoder.newDecoder(array, 0, fecParams, KS, sbn);
        }

        return srcBlockDecoders;
    }

    @Override
    public FECParameters fecParameters() {

        return fecParams;
    }

    @Override
    public long dataLength() {

        return fecParams.dataLength();
    }

    @Override
    public int symbolSize() {

        return fecParams.symbolSize();
    }

    @Override
    public int numberOfSourceBlocks() {

        return fecParams.numberOfSourceBlocks();
    }

    @Override
    public boolean isDataDecoded() {

        for (SourceBlockDecoder dec : srcBlockDecoders) {
            if (!dec.isSourceBlockDecoded()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public SourceBlockDecoder decoderForSourceBlock(int sourceBlockNum) {

        if (sourceBlockNum < 0 || sourceBlockNum >= srcBlockDecoders.length) {
            throw new IllegalArgumentException("invalid source block number");
        }

        return srcBlockDecoders[sourceBlockNum];
    }

    /**
     * Returns an array of bytes containing the decodable data.
     * 
     * @return an array of bytes containing the decodable data
     */
    public byte[] dataArray() {

        return array;
    }
}
