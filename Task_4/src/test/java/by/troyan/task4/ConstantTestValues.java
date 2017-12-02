package by.troyan.task4;

public class ConstantTestValues {


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


    public static final int testI = 5;
    public static final int testJ = 7;
}
