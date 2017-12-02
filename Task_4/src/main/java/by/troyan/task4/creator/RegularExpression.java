package by.troyan.task4.creator;

public class RegularExpression {

    public static final String REGEX_SENTENCE = "([^(\\.|!|\\?)]+)(\\.|!|\\?)";
    public static final String REGEX_WORD = "([^(\\s)]*)(\\s)*";
    public static final String REGEX_SYMBOL = ".{1}";
    public static final String REGEX_PARAGRAPH = "(?s)(.*?[^\\:\\-\\,])(?:$|\\n{2,})";
    public static final String REGEX_IANDJ = "\\+\\+i|--i|i--|i\\+\\+|\\+\\+j|--j|j--|j\\+\\+";
    public static final String REGEX_SPLIT_EXPRESSION = "\\p{Blank}+";
    public static final String REGEX_MATH_EXPRESSIONS = "[-(\\d]([\\d)\\s(+\\-*./])+[\\d)]";
    public static final String REGEX_SENTENCE_SPLITTER = "[.!?]\\s*";
    public static final String REGEX_WORD_SPLITTER = "[\\p{Punct}\\s]+";
    public static final String REGEX_LEXEMS_SPLITTER = "[[ ]*|[,]*|[\\.]*|[:]*|[/]*|[!]*|[?]*|[+]*]+";

}
