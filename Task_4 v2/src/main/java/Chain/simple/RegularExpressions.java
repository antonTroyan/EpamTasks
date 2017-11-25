package Chain.simple;

public class RegularExpressions {

    public static final String REGEX_SENTENCE = "([^(\\.|!|\\?)]+)(\\.|!|\\?)";
    public static final String REGEX_WORD = "([^(\\s)]*)(\\s)*";
    public static final String REGEX_SYMBOL = ".{1}";
    public static final String REGEX_PARAGRAPH = "(?s)(.*?[^\\:\\-\\,])(?:$|\\n{2,})";

    public static final String REGEX_WORD_AND_SIGN = "([\\.,!\\?:;@]{1})|([^\\.,!\\?:;@]*)";


}
