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

package net.fec.openrq.util.rq;

/**
 */
public final class SystematicIndices {

    public static int getKIndex(int K) {

        /*
         * if(K < 1) throw new IllegalArgumentException("K must be positive.");
         * if(K > 56403) throw new IllegalArgumentException("K must be smaller than 56403.");
         */

        for (int i = 0; i < table2.length; i++) {
            if (K(i) >= K) {
                return i;
            }
        }

        throw new RuntimeException("Invalid table state");
    }

    public static int K(int K_index) {

        return table2[K_index][0];
    }

    public static int J(int K_index) {

        return table2[K_index][1];
    }

    public static int S(int K_index) {

        return table2[K_index][2];
    }

    public static int H(int K_index) {

        return table2[K_index][3];
    }

    public static int W(int K_index) {

        return table2[K_index][4];
    }

    public static int ceil(int k) {

        /*
         * if(k < 1) throw new IllegalArgumentException("K must be positive.");
         * if(k > 56403) throw new IllegalArgumentException("K must be smaller than 56403.");
         */

        for (int i = 0; i < table2.length; i++) {
            if (K(i) >= k) {
                return (K(i));
            }
        }

        throw new RuntimeException("Invalid table state");
    }

    public static int floor(int k) {

        /*
         * if(k < 1) throw new IllegalArgumentException("K must be positive.");
         * if(k > 56403) throw new IllegalArgumentException("K must be smaller than 56403.");
         */

        for (int i = table2.length - 1; i >= 0; i--) {
            if (K(i) <= k) {
                return (K(i));
            }
        }

        throw new RuntimeException("Invalid table state");
    }


    private static final int table2[][] = {
                                           {10, 254, 7, 10, 17},
                                           {12, 630, 7, 10, 19},
                                           {18, 682, 11, 10, 29},
                                           {20, 293, 11, 10, 31},
                                           {26, 80, 11, 10, 37},
                                           {30, 566, 11, 10, 41},
                                           {32, 860, 11, 10, 43},
                                           {36, 267, 11, 10, 47},
                                           {42, 822, 11, 10, 53},
                                           {46, 506, 13, 10, 59},
                                           {48, 589, 13, 10, 61},
                                           {49, 87, 13, 10, 61},
                                           {55, 520, 13, 10, 67},
                                           {60, 159, 13, 10, 71},
                                           {62, 235, 13, 10, 73},
                                           {69, 157, 13, 10, 79},
                                           {75, 502, 17, 10, 89},
                                           {84, 334, 17, 10, 97},
                                           {88, 583, 17, 10, 101},
                                           {91, 66, 17, 10, 103},
                                           {95, 352, 17, 10, 107},
                                           {97, 365, 17, 10, 109},
                                           {101, 562, 17, 10, 113},
                                           {114, 5, 19, 10, 127},
                                           {119, 603, 19, 10, 131},
                                           {125, 721, 19, 10, 137},
                                           {127, 28, 19, 10, 139},
                                           {138, 660, 19, 10, 149},
                                           {140, 829, 19, 10, 151},
                                           {149, 900, 23, 10, 163},
                                           {153, 930, 23, 10, 167},
                                           {160, 814, 23, 10, 173},
                                           {166, 661, 23, 10, 179},
                                           {168, 693, 23, 10, 181},
                                           {179, 780, 23, 10, 191},
                                           {181, 605, 23, 10, 193},
                                           {185, 551, 23, 10, 197},
                                           {187, 777, 23, 10, 199},
                                           {200, 491, 23, 10, 211},
                                           {213, 396, 23, 10, 223},
                                           {217, 764, 29, 10, 233},
                                           {225, 843, 29, 10, 241},
                                           {236, 646, 29, 10, 251},
                                           {242, 557, 29, 10, 257},
                                           {248, 608, 29, 10, 263},
                                           {257, 265, 29, 10, 271},
                                           {263, 505, 29, 10, 277},
                                           {269, 722, 29, 10, 283},
                                           {280, 263, 29, 10, 293},
                                           {295, 999, 29, 10, 307},
                                           {301, 874, 29, 10, 313},
                                           {305, 160, 29, 10, 317},
                                           {324, 575, 31, 10, 337},
                                           {337, 210, 31, 10, 349},
                                           {341, 513, 31, 10, 353},
                                           {347, 503, 31, 10, 359},
                                           {355, 558, 31, 10, 367},
                                           {362, 932, 31, 10, 373},
                                           {368, 404, 31, 10, 379},
                                           {372, 520, 37, 10, 389},
                                           {380, 846, 37, 10, 397},
                                           {385, 485, 37, 10, 401},
                                           {393, 728, 37, 10, 409},
                                           {405, 554, 37, 10, 421},
                                           {418, 471, 37, 10, 433},
                                           {428, 641, 37, 10, 443},
                                           {434, 732, 37, 10, 449},
                                           {447, 193, 37, 10, 461},
                                           {453, 934, 37, 10, 467},
                                           {466, 864, 37, 10, 479},
                                           {478, 790, 37, 10, 491},
                                           {486, 912, 37, 10, 499},
                                           {491, 617, 37, 10, 503},
                                           {497, 587, 37, 10, 509},
                                           {511, 800, 37, 10, 523},
                                           {526, 923, 41, 10, 541},
                                           {532, 998, 41, 10, 547},
                                           {542, 92, 41, 10, 557},
                                           {549, 497, 41, 10, 563},
                                           {557, 559, 41, 10, 571},
                                           {563, 667, 41, 10, 577},
                                           {573, 912, 41, 10, 587},
                                           {580, 262, 41, 10, 593},
                                           {588, 152, 41, 10, 601},
                                           {594, 526, 41, 10, 607},
                                           {600, 268, 41, 10, 613},
                                           {606, 212, 41, 10, 619},
                                           {619, 45, 41, 10, 631},
                                           {633, 898, 43, 10, 647},
                                           {640, 527, 43, 10, 653},
                                           {648, 558, 43, 10, 661},
                                           {666, 460, 47, 10, 683},
                                           {675, 5, 47, 10, 691},
                                           {685, 895, 47, 10, 701},
                                           {693, 996, 47, 10, 709},
                                           {703, 282, 47, 10, 719},
                                           {718, 513, 47, 10, 733},
                                           {728, 865, 47, 10, 743},
                                           {736, 870, 47, 10, 751},
                                           {747, 239, 47, 10, 761},
                                           {759, 452, 47, 10, 773},
                                           {778, 862, 53, 10, 797},
                                           {792, 852, 53, 10, 811},
                                           {802, 643, 53, 10, 821},
                                           {811, 543, 53, 10, 829},
                                           {821, 447, 53, 10, 839},
                                           {835, 321, 53, 10, 853},
                                           {845, 287, 53, 10, 863},
                                           {860, 12, 53, 10, 877},
                                           {870, 251, 53, 10, 887},
                                           {891, 30, 53, 10, 907},
                                           {903, 621, 53, 10, 919},
                                           {913, 555, 53, 10, 929},
                                           {926, 127, 53, 10, 941},
                                           {938, 400, 53, 10, 953},
                                           {950, 91, 59, 10, 971},
                                           {963, 916, 59, 10, 983},
                                           {977, 935, 59, 10, 997},
                                           {989, 691, 59, 10, 1009},
                                           {1002, 299, 59, 10, 1021},
                                           {1020, 282, 59, 10, 1039},
                                           {1032, 824, 59, 10, 1051},
                                           {1050, 536, 59, 11, 1069},
                                           {1074, 596, 59, 11, 1093},
                                           {1085, 28, 59, 11, 1103},
                                           {1099, 947, 59, 11, 1117},
                                           {1111, 162, 59, 11, 1129},
                                           {1136, 536, 59, 11, 1153},
                                           {1152, 1000, 61, 11, 1171},
                                           {1169, 251, 61, 11, 1187},
                                           {1183, 673, 61, 11, 1201},
                                           {1205, 559, 61, 11, 1223},
                                           {1220, 923, 61, 11, 1237},
                                           {1236, 81, 67, 11, 1259},
                                           {1255, 478, 67, 11, 1277},
                                           {1269, 198, 67, 11, 1291},
                                           {1285, 137, 67, 11, 1307},
                                           {1306, 75, 67, 11, 1327},
                                           {1347, 29, 67, 11, 1367},
                                           {1361, 231, 67, 11, 1381},
                                           {1389, 532, 67, 11, 1409},
                                           {1404, 58, 67, 11, 1423},
                                           {1420, 60, 67, 11, 1439},
                                           {1436, 964, 71, 11, 1459},
                                           {1461, 624, 71, 11, 1483},
                                           {1477, 502, 71, 11, 1499},
                                           {1502, 636, 71, 11, 1523},
                                           {1522, 986, 71, 11, 1543},
                                           {1539, 950, 71, 11, 1559},
                                           {1561, 735, 73, 11, 1583},
                                           {1579, 866, 73, 11, 1601},
                                           {1600, 203, 73, 11, 1621},
                                           {1616, 83, 73, 11, 1637},
                                           {1649, 14, 73, 11, 1669},
                                           {1673, 522, 79, 11, 1699},
                                           {1698, 226, 79, 11, 1723},
                                           {1716, 282, 79, 11, 1741},
                                           {1734, 88, 79, 11, 1759},
                                           {1759, 636, 79, 11, 1783},
                                           {1777, 860, 79, 11, 1801},
                                           {1800, 324, 79, 11, 1823},
                                           {1824, 424, 79, 11, 1847},
                                           {1844, 999, 79, 11, 1867},
                                           {1863, 682, 83, 11, 1889},
                                           {1887, 814, 83, 11, 1913},
                                           {1906, 979, 83, 11, 1931},
                                           {1926, 538, 83, 11, 1951},
                                           {1954, 278, 83, 11, 1979},
                                           {1979, 580, 83, 11, 2003},
                                           {2005, 773, 83, 11, 2029},
                                           {2040, 911, 89, 11, 2069},
                                           {2070, 506, 89, 11, 2099},
                                           {2103, 628, 89, 11, 2131},
                                           {2125, 282, 89, 11, 2153},
                                           {2152, 309, 89, 11, 2179},
                                           {2195, 858, 89, 11, 2221},
                                           {2217, 442, 89, 11, 2243},
                                           {2247, 654, 89, 11, 2273},
                                           {2278, 82, 97, 11, 2311},
                                           {2315, 428, 97, 11, 2347},
                                           {2339, 442, 97, 11, 2371},
                                           {2367, 283, 97, 11, 2399},
                                           {2392, 538, 97, 11, 2423},
                                           {2416, 189, 97, 11, 2447},
                                           {2447, 438, 97, 11, 2477},
                                           {2473, 912, 97, 11, 2503},
                                           {2502, 1, 97, 11, 2531},
                                           {2528, 167, 97, 11, 2557},
                                           {2565, 272, 97, 11, 2593},
                                           {2601, 209, 101, 11, 2633},
                                           {2640, 927, 101, 11, 2671},
                                           {2668, 386, 101, 11, 2699},
                                           {2701, 653, 101, 11, 2731},
                                           {2737, 669, 101, 11, 2767},
                                           {2772, 431, 101, 11, 2801},
                                           {2802, 793, 103, 11, 2833},
                                           {2831, 588, 103, 11, 2861},
                                           {2875, 777, 107, 11, 2909},
                                           {2906, 939, 107, 11, 2939},
                                           {2938, 864, 107, 11, 2971},
                                           {2979, 627, 107, 11, 3011},
                                           {3015, 265, 109, 11, 3049},
                                           {3056, 976, 109, 11, 3089},
                                           {3101, 988, 113, 11, 3137},
                                           {3151, 507, 113, 11, 3187},
                                           {3186, 640, 113, 11, 3221},
                                           {3224, 15, 113, 11, 3259},
                                           {3265, 667, 113, 11, 3299},
                                           {3299, 24, 127, 11, 3347},
                                           {3344, 877, 127, 11, 3391},
                                           {3387, 240, 127, 11, 3433},
                                           {3423, 720, 127, 11, 3469},
                                           {3466, 93, 127, 11, 3511},
                                           {3502, 919, 127, 11, 3547},
                                           {3539, 635, 127, 11, 3583},
                                           {3579, 174, 127, 11, 3623},
                                           {3616, 647, 127, 11, 3659},
                                           {3658, 820, 127, 11, 3701},
                                           {3697, 56, 127, 11, 3739},
                                           {3751, 485, 127, 11, 3793},
                                           {3792, 210, 127, 11, 3833},
                                           {3840, 124, 127, 11, 3881},
                                           {3883, 546, 127, 11, 3923},
                                           {3924, 954, 131, 11, 3967},
                                           {3970, 262, 131, 11, 4013},
                                           {4015, 927, 131, 11, 4057},
                                           {4069, 957, 131, 11, 4111},
                                           {4112, 726, 137, 11, 4159},
                                           {4165, 583, 137, 11, 4211},
                                           {4207, 782, 137, 11, 4253},
                                           {4252, 37, 137, 11, 4297},
                                           {4318, 758, 137, 11, 4363},
                                           {4365, 777, 137, 11, 4409},
                                           {4418, 104, 139, 11, 4463},
                                           {4468, 476, 139, 11, 4513},
                                           {4513, 113, 149, 11, 4567},
                                           {4567, 313, 149, 11, 4621},
                                           {4626, 102, 149, 11, 4679},
                                           {4681, 501, 149, 11, 4733},
                                           {4731, 332, 149, 11, 4783},
                                           {4780, 786, 149, 11, 4831},
                                           {4838, 99, 149, 11, 4889},
                                           {4901, 658, 149, 11, 4951},
                                           {4954, 794, 149, 11, 5003},
                                           {5008, 37, 151, 11, 5059},
                                           {5063, 471, 151, 11, 5113},
                                           {5116, 94, 157, 11, 5171},
                                           {5172, 873, 157, 11, 5227},
                                           {5225, 918, 157, 11, 5279},
                                           {5279, 945, 157, 11, 5333},
                                           {5334, 211, 157, 11, 5387},
                                           {5391, 341, 157, 11, 5443},
                                           {5449, 11, 163, 11, 5507},
                                           {5506, 578, 163, 11, 5563},
                                           {5566, 494, 163, 11, 5623},
                                           {5637, 694, 163, 11, 5693},
                                           {5694, 252, 163, 11, 5749},
                                           {5763, 451, 167, 11, 5821},
                                           {5823, 83, 167, 11, 5881},
                                           {5896, 689, 167, 11, 5953},
                                           {5975, 488, 173, 11, 6037},
                                           {6039, 214, 173, 11, 6101},
                                           {6102, 17, 173, 11, 6163},
                                           {6169, 469, 173, 11, 6229},
                                           {6233, 263, 179, 11, 6299},
                                           {6296, 309, 179, 11, 6361},
                                           {6363, 984, 179, 11, 6427},
                                           {6427, 123, 179, 11, 6491},
                                           {6518, 360, 179, 11, 6581},
                                           {6589, 863, 181, 11, 6653},
                                           {6655, 122, 181, 11, 6719},
                                           {6730, 522, 191, 11, 6803},
                                           {6799, 539, 191, 11, 6871},
                                           {6878, 181, 191, 11, 6949},
                                           {6956, 64, 191, 11, 7027},
                                           {7033, 387, 191, 11, 7103},
                                           {7108, 967, 191, 11, 7177},
                                           {7185, 843, 191, 11, 7253},
                                           {7281, 999, 193, 11, 7351},
                                           {7360, 76, 197, 11, 7433},
                                           {7445, 142, 197, 11, 7517},
                                           {7520, 599, 197, 11, 7591},
                                           {7596, 576, 199, 11, 7669},
                                           {7675, 176, 211, 11, 7759},
                                           {7770, 392, 211, 11, 7853},
                                           {7855, 332, 211, 11, 7937},
                                           {7935, 291, 211, 11, 8017},
                                           {8030, 913, 211, 11, 8111},
                                           {8111, 608, 211, 11, 8191},
                                           {8194, 212, 211, 11, 8273},
                                           {8290, 696, 211, 11, 8369},
                                           {8377, 931, 223, 11, 8467},
                                           {8474, 326, 223, 11, 8563},
                                           {8559, 228, 223, 11, 8647},
                                           {8654, 706, 223, 11, 8741},
                                           {8744, 144, 223, 11, 8831},
                                           {8837, 83, 223, 11, 8923},
                                           {8928, 743, 223, 11, 9013},
                                           {9019, 187, 223, 11, 9103},
                                           {9111, 654, 227, 11, 9199},
                                           {9206, 359, 227, 11, 9293},
                                           {9303, 493, 229, 11, 9391},
                                           {9400, 369, 233, 11, 9491},
                                           {9497, 981, 233, 11, 9587},
                                           {9601, 276, 239, 11, 9697},
                                           {9708, 647, 239, 11, 9803},
                                           {9813, 389, 239, 11, 9907},
                                           {9916, 80, 239, 11, 10009},
                                           {10017, 396, 241, 11, 10111},
                                           {10120, 580, 251, 11, 10223},
                                           {10241, 873, 251, 11, 10343},
                                           {10351, 15, 251, 11, 10453},
                                           {10458, 976, 251, 11, 10559},
                                           {10567, 584, 251, 11, 10667},
                                           {10676, 267, 257, 11, 10781},
                                           {10787, 876, 257, 11, 10891},
                                           {10899, 642, 257, 12, 11003},
                                           {11015, 794, 257, 12, 11119},
                                           {11130, 78, 263, 12, 11239},
                                           {11245, 736, 263, 12, 11353},
                                           {11358, 882, 269, 12, 11471},
                                           {11475, 251, 269, 12, 11587},
                                           {11590, 434, 269, 12, 11701},
                                           {11711, 204, 269, 12, 11821},
                                           {11829, 256, 271, 12, 11941},
                                           {11956, 106, 277, 12, 12073},
                                           {12087, 375, 277, 12, 12203},
                                           {12208, 148, 277, 12, 12323},
                                           {12333, 496, 281, 12, 12451},
                                           {12460, 88, 281, 12, 12577},
                                           {12593, 826, 293, 12, 12721},
                                           {12726, 71, 293, 12, 12853},
                                           {12857, 925, 293, 12, 12983},
                                           {13002, 760, 293, 12, 13127},
                                           {13143, 130, 293, 12, 13267},
                                           {13284, 641, 307, 12, 13421},
                                           {13417, 400, 307, 12, 13553},
                                           {13558, 480, 307, 12, 13693},
                                           {13695, 76, 307, 12, 13829},
                                           {13833, 665, 307, 12, 13967},
                                           {13974, 910, 307, 12, 14107},
                                           {14115, 467, 311, 12, 14251},
                                           {14272, 964, 311, 12, 14407},
                                           {14415, 625, 313, 12, 14551},
                                           {14560, 362, 317, 12, 14699},
                                           {14713, 759, 317, 12, 14851},
                                           {14862, 728, 331, 12, 15013},
                                           {15011, 343, 331, 12, 15161},
                                           {15170, 113, 331, 12, 15319},
                                           {15325, 137, 331, 12, 15473},
                                           {15496, 308, 331, 12, 15643},
                                           {15651, 800, 337, 12, 15803},
                                           {15808, 177, 337, 12, 15959},
                                           {15977, 961, 337, 12, 16127},
                                           {16161, 958, 347, 12, 16319},
                                           {16336, 72, 347, 12, 16493},
                                           {16505, 732, 347, 12, 16661},
                                           {16674, 145, 349, 12, 16831},
                                           {16851, 577, 353, 12, 17011},
                                           {17024, 305, 353, 12, 17183},
                                           {17195, 50, 359, 12, 17359},
                                           {17376, 351, 359, 12, 17539},
                                           {17559, 175, 367, 12, 17729},
                                           {17742, 727, 367, 12, 17911},
                                           {17929, 902, 367, 12, 18097},
                                           {18116, 409, 373, 12, 18289},
                                           {18309, 776, 373, 12, 18481},
                                           {18503, 586, 379, 12, 18679},
                                           {18694, 451, 379, 12, 18869},
                                           {18909, 287, 383, 12, 19087},
                                           {19126, 246, 389, 12, 19309},
                                           {19325, 222, 389, 12, 19507},
                                           {19539, 563, 397, 12, 19727},
                                           {19740, 839, 397, 12, 19927},
                                           {19939, 897, 401, 12, 20129},
                                           {20152, 409, 401, 12, 20341},
                                           {20355, 618, 409, 12, 20551},
                                           {20564, 439, 409, 12, 20759},
                                           {20778, 95, 419, 13, 20983},
                                           {20988, 448, 419, 13, 21191},
                                           {21199, 133, 419, 13, 21401},
                                           {21412, 938, 419, 13, 21613},
                                           {21629, 423, 431, 13, 21841},
                                           {21852, 90, 431, 13, 22063},
                                           {22073, 640, 431, 13, 22283},
                                           {22301, 922, 433, 13, 22511},
                                           {22536, 250, 439, 13, 22751},
                                           {22779, 367, 439, 13, 22993},
                                           {23010, 447, 443, 13, 23227},
                                           {23252, 559, 449, 13, 23473},
                                           {23491, 121, 457, 13, 23719},
                                           {23730, 623, 457, 13, 23957},
                                           {23971, 450, 457, 13, 24197},
                                           {24215, 253, 461, 13, 24443},
                                           {24476, 106, 467, 13, 24709},
                                           {24721, 863, 467, 13, 24953},
                                           {24976, 148, 479, 13, 25219},
                                           {25230, 427, 479, 13, 25471},
                                           {25493, 138, 479, 13, 25733},
                                           {25756, 794, 487, 13, 26003},
                                           {26022, 247, 487, 13, 26267},
                                           {26291, 562, 491, 13, 26539},
                                           {26566, 53, 499, 13, 26821},
                                           {26838, 135, 499, 13, 27091},
                                           {27111, 21, 503, 13, 27367},
                                           {27392, 201, 509, 13, 27653},
                                           {27682, 169, 521, 13, 27953},
                                           {27959, 70, 521, 13, 28229},
                                           {28248, 386, 521, 13, 28517},
                                           {28548, 226, 523, 13, 28817},
                                           {28845, 3, 541, 13, 29131},
                                           {29138, 769, 541, 13, 29423},
                                           {29434, 590, 541, 13, 29717},
                                           {29731, 672, 541, 13, 30013},
                                           {30037, 713, 547, 13, 30323},
                                           {30346, 967, 547, 13, 30631},
                                           {30654, 368, 557, 14, 30949},
                                           {30974, 348, 557, 14, 31267},
                                           {31285, 119, 563, 14, 31583},
                                           {31605, 503, 569, 14, 31907},
                                           {31948, 181, 571, 14, 32251},
                                           {32272, 394, 577, 14, 32579},
                                           {32601, 189, 587, 14, 32917},
                                           {32932, 210, 587, 14, 33247},
                                           {33282, 62, 593, 14, 33601},
                                           {33623, 273, 593, 14, 33941},
                                           {33961, 554, 599, 14, 34283},
                                           {34302, 936, 607, 14, 34631},
                                           {34654, 483, 607, 14, 34981},
                                           {35031, 397, 613, 14, 35363},
                                           {35395, 241, 619, 14, 35731},
                                           {35750, 500, 631, 14, 36097},
                                           {36112, 12, 631, 14, 36457},
                                           {36479, 958, 641, 14, 36833},
                                           {36849, 524, 641, 14, 37201},
                                           {37227, 8, 643, 14, 37579},
                                           {37606, 100, 653, 14, 37967},
                                           {37992, 339, 653, 14, 38351},
                                           {38385, 804, 659, 14, 38749},
                                           {38787, 510, 673, 14, 39163},
                                           {39176, 18, 673, 14, 39551},
                                           {39576, 412, 677, 14, 39953},
                                           {39980, 394, 683, 14, 40361},
                                           {40398, 830, 691, 15, 40787},
                                           {40816, 535, 701, 15, 41213},
                                           {41226, 199, 701, 15, 41621},
                                           {41641, 27, 709, 15, 42043},
                                           {42067, 298, 709, 15, 42467},
                                           {42490, 368, 719, 15, 42899},
                                           {42916, 755, 727, 15, 43331},
                                           {43388, 379, 727, 15, 43801},
                                           {43840, 73, 733, 15, 44257},
                                           {44279, 387, 739, 15, 44701},
                                           {44729, 457, 751, 15, 45161},
                                           {45183, 761, 751, 15, 45613},
                                           {45638, 855, 757, 15, 46073},
                                           {46104, 370, 769, 15, 46549},
                                           {46574, 261, 769, 15, 47017},
                                           {47047, 299, 787, 15, 47507},
                                           {47523, 920, 787, 15, 47981},
                                           {48007, 269, 787, 15, 48463},
                                           {48489, 862, 797, 15, 48953},
                                           {48976, 349, 809, 15, 49451},
                                           {49470, 103, 809, 15, 49943},
                                           {49978, 115, 821, 15, 50461},
                                           {50511, 93, 821, 16, 50993},
                                           {51017, 982, 827, 16, 51503},
                                           {51530, 432, 839, 16, 52027},
                                           {52062, 340, 853, 16, 52571},
                                           {52586, 173, 853, 16, 53093},
                                           {53114, 421, 857, 16, 53623},
                                           {53650, 330, 863, 16, 54163},
                                           {54188, 624, 877, 16, 54713},
                                           {54735, 233, 877, 16, 55259},
                                           {55289, 362, 883, 16, 55817},
                                           {55843, 963, 907, 16, 56393},
                                           {56403, 471, 907, 16, 56951}
    };


    private SystematicIndices() {

        // not instantiable
    }
}
