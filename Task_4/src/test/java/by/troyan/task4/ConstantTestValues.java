package by.troyan.task4;

public class ConstantTestValues {

    public static final int TEST_I = 5;
    public static final int TEST_J = 7;

    public static final String RIGHT_LEXEMS_IN_ALPHOBETIC = "\t-10800\n"+ "-355\n"+ "\t15\n"+ "18\n"+ "\t8\n"+ "\tAldus\n"+
            "\tBye\n"+ "\tEnglish\n"+ "\tIpsum\n"+ "Ipsum\n"+ "It\n"+ "It\n"+ "It\n"+ "\tLetraset\n"+ "Lorem\n"+ "Lorem\n"+
            "\tPageMaker\n"+ "\ta\n"+ "a\n"+ "a\n"+ "a\n"+ "a\n"+ "a\n"+ "also\n"+ "and\n"+ "at\n"+ "at\n"+ "\tbe\n"+
            "be\n"+ "but\n"+ "by\n"+ "\tcenturies\n"+ "containing\n"+ "content\n"+ "content\n"+ "\tdesktop\n"+ "distracted\n"+
            "\telectronic\n"+ "essentially\n"+ "established\n"+ "established\n"+ "\tfact\n"+ "fact\n"+ "\there'\n"+ "\tin\n"+
            "including\n"+ "into\n"+ "is\n"+ "is\n"+ "it\n"+ "its\n"+ "its\n"+ "\tlayout\n"+ "layout\n"+ "leap\n"+ "like\n"+
            "like\n"+ "long\n"+ "look\n"+ "looking\n"+ "looking\n"+ "\tmaking\n"+ "more\n"+ "\tof\n"+ "of\n"+ "of\n"+
            "of\n"+ "\tpage\n"+ "page\n"+ "passages\n"+ "popularised\n"+ "publishing\n"+ "\treadable\n"+ "readable\n"+
            "reader\n"+ "reader\n"+ "recently\n"+ "release\n"+ "remaining\n"+ "\tsheets\n"+ "software\n"+ "\tthat\n"+
            "that\n"+ "the\n"+ "the\n"+ "the\n"+ "the\n"+ "typesetting\n"+ "\tunchanged\n"+ "\tversions\n"+ "\twas\n"+
            "when\n"+ "when\n"+ "will\n"+ "will\n"+ "with\n"+ "with\n";

    public static final String RIGHT_SENTENCE_SORT = "Bye: 1\n" +
            ",  content  here',  making  it  look  like  readable  English: 9\n" +
            "      centuries,  but  also  the  leap  into  18 electronic  typesetting,  remaining  8  essentially  " +
            "15  unchanged: 15\n" +
            "It  is  a  -10800  established  fact  that  a  reader  will  be  of  a  page when  looking  at  its " +
            " layout: 19\n" +
            "It  is  a  long  established  fact  that  a  reader  will  be  distracted  by  the  readable content  of" +
            "  a  page  when  looking  at  its  layout: 24\n" +
            "It  was popularised  in  the  -355  with  the  release  of  Letraset  sheets containing  Lorem  Ipsum  " +
            "passages,  and  more  recently  with  desktop  publishing  software like  Aldus  PageMaker  including  " +
            "versions  of  Lorem  Ipsum: 31\n";

    public static final String TEST_TEXT = "\n" +
            "    It has survived - not only (five) centuries, but also the leap into 13+ i--\n" +
            "electronic typesetting, remaining 3+5 essentially 6+9*(3-4) unchanged. It was\n" +
            "popularised in the 5*(1*2*(2*(4*(5- --j + 4)-3)-2)-1) with the release of Letraset sheets\n" +
            "containing Lorem Ipsum passages, and more recently with desktop publishing software\n" +
            "like Aldus PageMaker including versions of Lorem Ipsum.\n" +
            "\n" +
            "    It is a long established fact that a reader will be distracted by the readable\n" +
            "content of a page when looking at its layout. The point of using (71-(2*i--*(3*(2-1/2*2)\n" +
            "-2)-10/2))*++i Ipsum is that it has a more-or-less normal distribution of letters, as\n" +
            "opposed to using (Content here), content here', making it look like readable English.\n" +
            "\n" +
            "    It is a (5+1/2*(2+5*2- --j))*1200 established fact that a reader will be of a page\n" +
            "when looking at its layout.\n" +
            "\n" +
            "    Bye.";

    public static final String RIGHT_RESULT_TEXT_WITH_PARAMETERS = "\n" +
            "    It has survived - not only (five) centuries, but also the leap into 13+ 5\n" +
            "electronic typesetting, remaining 3+5 essentially 6+9*(3-4) unchanged. It was\n" +
            "popularised in the 5*(1*2*(2*(4*(5- 6 + 4)-3)-2)-1) with the release of Letraset sheets\n" +
            "containing Lorem Ipsum passages, and more recently with desktop publishing software\n" +
            "like Aldus PageMaker including versions of Lorem Ipsum.\n" +
            "\n" +
            "    It is a long established fact that a reader will be distracted by the readable\n" +
            "content of a page when looking at its layout. The point of using (71-(2*4*(3*(2-1/2*2)\n" +
            "-2)-10/2))*4 Ipsum is that it has a more-or-less normal distribution of letters, as\n" +
            "opposed to using (Content here), content here', making it look like readable English.\n" +
            "\n" +
            "    It is a (5+1/2*(2+5*2- 5))*1200 established fact that a reader will be of a page\n" +
            "when looking at its layout.\n" +
            "\n" +
            "    Bye.\n";

    public static final String RIGHT_RESULT_TEXT = "\n    It has survived - not only (five) centuries, but also the leap into 18\n" +
            "electronic typesetting, remaining 8 essentially 15 unchanged. It was\n" +
            "popularised in the -355 with the release of Letraset sheets\n" +
            "containing Lorem Ipsum passages, and more recently with desktop publishing software\n" +
            "like Aldus PageMaker including versions of Lorem Ipsum.\n" +
            "\n" +
            "    It is a long established fact that a reader will be distracted by the readable\n" +
            "content of a page when looking at its layout. The point of using -156 Ipsum is that it has a more-or-less normal distribution of letters, as\n" +
            "opposed to using (Content here), content here', making it look like readable English.\n" +
            "\n" +
            "    It is a -10800 established fact that a reader will be of a page\n" +
            "when looking at its layout.\n" +
            "\n" +
            "    Bye.\n";


}
