package net.fec.openrq;


import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;


/**
 * @author Jos&#233; Lopes &lt;jlopes&#064;lasige.di.fc.ul.pt&gt;
 * @author Ricardo Fonseca &lt;ricardof&#064;lasige.di.fc.ul.pt&gt;
 */
public final class PacketHeader {

    // Enum state to avoid throwing exceptions when the user parses an illegal header.
    public static enum HeaderState {

        VALID,
        INVALID_SOURCE_BLOCK_NUMBER,
        INVALID_ENCODING_SYMBOL_ID,
        INVALID_NUM_SYMBOLS;
    }


    /**
     * Writes in the provided buffer a header containing a sequence of bytes that represent the provided packet
     * parameters.
     * <p>
     * The provided buffer must not be {@linkplain ByteBuffer#isReadOnly() read-only}, and must have at least 6 bytes
     * {@linkplain ByteBuffer#remaining() remaining}. If this method returns normally, the position of the provided
     * buffer will have advanced by 6 bytes.
     * 
     * @param params
     *            The packet parameters associated to some encoding packet
     * @param buffer
     *            A buffer on which the packet header is written
     * @exception NullPointerException
     *                If the provided packet parameters or the buffer are {@code null}
     * @exception ReadOnlyBufferException
     *                If the provided buffer is read-only
     * @exception BufferOverflowException
     *                If the provided buffer has less than 6 bytes remaining
     */
    public static void writeHeader(PacketParameters params, ByteBuffer buffer) {

        // write SBN, ESI, NUM_SYMBOLS
        ValueChecker.writeSourceBlockNumber(params.getSourceBlockNumber(), buffer); // 1 bytes
        ValueChecker.writeEncodingSymbolID(params.getEncodingSymbolID(), buffer);   // 3 bytes
        ValueChecker.writeNumSymbols(params.getNumberOfSymbols(), buffer);          // 2 bytes
    }

    /**
     * Reads from the provided buffer a {@code PacketHeader} instance.
     * <p>
     * The provided buffer must have at least 6 bytes {@linkplain ByteBuffer#remaining() remaining}. If this method
     * returns normally, the position of the provided buffer will have advanced by 6 bytes.
     * <p>
     * The returned {@code PacketHeader} instance is only {@linkplain #isValid() valid} if the packet parameters
     * contained inside the buffer have valid values. If some parameter value is invalid, the method
     * {@link DataHeader#getState()} can be used to infer which parameter value is invalid.
     * 
     * @param buffer
     *            A buffer from which a {@code PacketHeader} instance is read
     * @return a {@code PacketHeader} instance
     * @exception IllegalArgumentException
     *                If {@code ValueChecker.isValidSymbolSize(symbolSize) == false}
     * @exception NullPointerException
     *                If the provided buffer is {@code null}
     * @exception BufferUnderflowException
     *                If the provided buffer has less than 6 bytes remaining
     */
    public static PacketHeader readHeader(ByteBuffer buffer) {

        // read SBN, ESI, NUM_SYMBOLS
        final int sourceBlockNum = ValueChecker.readSourceBlockNumber(buffer); // 1 byte
        final int encSymbolID = ValueChecker.readEncodingSymbolID(buffer);     // 3 bytes
        final int numSymbols = ValueChecker.readNumSymbols(buffer);            // 2 bytes

        if (!ValueChecker.isValidSourceBlockNumber(sourceBlockNum)) {
            return new PacketHeader(PacketHeader.HeaderState.INVALID_SOURCE_BLOCK_NUMBER, null);
        }
        else if (!ValueChecker.isValidEncodingSymbolID(encSymbolID)) {
            return new PacketHeader(PacketHeader.HeaderState.INVALID_ENCODING_SYMBOL_ID, null);
        }
        else if (!ValueChecker.isValidNumSymbols(numSymbols)) {
            return new PacketHeader(PacketHeader.HeaderState.INVALID_NUM_SYMBOLS, null);
        }
        else {
            return new PacketHeader(
                PacketHeader.HeaderState.VALID,
                new PacketParameters(sourceBlockNum, encSymbolID, numSymbols));
        }
    }


    private final PacketHeader.HeaderState state;
    private final PacketParameters packetParams;


    PacketHeader(PacketHeader.HeaderState state, PacketParameters packetParams) {

        this.state = state;
        this.packetParams = packetParams;
    }

    /**
     * @return
     */
    public boolean isValid() {

        return state == PacketHeader.HeaderState.VALID;
    }

    /**
     * @return
     */
    public PacketHeader.HeaderState getState() {

        return state;
    }

    /**
     * @return
     */
    public PacketParameters getDataParameters() {

        checkValid();
        return packetParams;
    }

    private void checkValid() {

        if (!isValid()) {
            final String errorMsg;
            switch (state) {
                case INVALID_SOURCE_BLOCK_NUMBER:
                    errorMsg = "invalid source block number";
                break;
                case INVALID_ENCODING_SYMBOL_ID:
                    errorMsg = "invalid encoding symbol identifier";
                break;
                case INVALID_NUM_SYMBOLS:
                    errorMsg = "invalid number symbols";
                break;
                default:
                    // should never happen
                    throw new AssertionError("unknown enum type");
            }
            throw new IllegalStateException(errorMsg);
        }
    }
}
