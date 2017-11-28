package creator;

public class RegularExpressions {

    public static final String REGEX_SENTENCE = "([^(\\.|!|\\?)]+)(\\.|!|\\?)";
    public static final String REGEX_WORD = "([^(\\s)]*)(\\s)*";
    public static final String REGEX_SYMBOL = ".{1}";
    public static final String REGEX_PARAGRAPH = "(?s)(.*?[^\\:\\-\\,])(?:$|\\n{2,})";
    public static final String REGEX_IANDJ = "\\+\\+i|--i|i--|i\\+\\+|\\+\\+j|--j|j--|j\\+\\+";
    public static final String REGEX_SPLIT_EXPRESSION = "\\p{Blank}+";
    public static final String REGEX_MATH_EXPRESSIONS = "[-(\\d]([\\d)\\s(+\\-*./])+[\\d)]";



}
