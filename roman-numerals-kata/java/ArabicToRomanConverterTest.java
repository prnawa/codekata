import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArabicToRomanConverterTest {

    ArabicToRomanConverter converter;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, "I", "Basic symbol conversion"},
                {5, "V", "Basic symbol conversion"},
                {10, "X", "Basic symbol conversion"},
                {50, "L", "Basic symbol conversion"},
                {100, "C", "Basic symbol conversion"},
                {500, "D", "Basic symbol conversion"},
                {1000, "M", "Basic symbol conversion"},

                {2, "II", "1st highest of basic symbol"},
                {6, "VI", "1st highest of basic symbol"},
                {11, "XI", "1st highest of basic symbol"},
                {51, "LI", "1st highest of basic symbol"},
                {101, "CI", "1st highest of basic symbol"},
                {501, "DI", "1st highest of basic symbol"},


                {3, "III", "2nd highest of basic symbol"},
                {7, "VII", "2nd highest of basic symbol"},
                {12, "XII", "2nd highest of basic symbol"},
                {52, "LII", "2nd highest of basic symbol"},
                {102, "CII", "2nd highest of basic symbol"},
                {502, "DII", "2nd highest of basic symbol"},


                {4, "IV", "3rd highest of basic symbol"},
                {8, "VIII", "3rd highest of basic symbol"},
                {13, "XIII", "3rd highest of basic symbol"},
                {53, "LIII", "3rd highest of basic symbol"},
                {103, "CIII", "3rd highest of basic symbol"},
                {503, "DIII", "3rd highest of basic symbol"},


                {9, "IX", "3rd highest of basic symbol"},
                {14, "XIV", "3rd highest of basic symbol"},
                {54, "LIV", "3rd highest of basic symbol"},
                {104, "CIV", "3rd highest of basic symbol"},
                {504, "DIV", "3rd highest of basic symbol"},


                {15, "XV", "4th highest of basic symbol"},
                {55, "LV", "4th highest of basic symbol"},
                {105, "CV", "4th highest of basic symbol"},
                {505, "DV", "4th highest of basic symbol"},


                {16, "XVI", "5th highest of basic symbol"},
                {56, "LVI", "5th highest of basic symbol"},
                {106, "CVI", "5th highest of basic symbol"},
                {506, "DVI", "5th highest of basic symbol"},


                {17, "XVII", "5th highest of basic symbol"},
                {57, "LVII", "5th highest of basic symbol"},
                {107, "CVII", "5th highest of basic symbol"},
                {507, "DVII", "5th highest of basic symbol"},


                {18, "XVIII", "5th highest of basic symbol"},
                {58, "LVIII", "5th highest of basic symbol"},
                {108, "CVIII", "5th highest of basic symbol"},
                {508, "DVIII", "5th highest of basic symbol"},


                {19, "XIX", "5th highest of basic symbol"},
                {59, "LIX", "5th highest of basic symbol"},
                {109, "CIX", "5th highest of basic symbol"},
                {509, "DIX", "5th highest of basic symbol"},


                {20, "XX", "5th highest of basic symbol"},
                {60, "LX", "5th highest of basic symbol"},
                {110, "CX", "5th highest of basic symbol"},
                {510, "DX", "5th highest of basic symbol"},


                {21, "XXI", "5th highest of basic symbol"},
                {61, "LXI", "5th highest of basic symbol"},
                {111, "CXI", "5th highest of basic symbol"},
                {511, "DXI", "5th highest of basic symbol"},


                {22, "XXII", "5th highest of basic symbol"},
                {62, "LXII", "5th highest of basic symbol"},
                {112, "CXII", "5th highest of basic symbol"},
                {512, "DXII", "5th highest of basic symbol"},

                {90, "XC", "5th highest of basic symbol"},
                {91, "XCI", "5th highest of basic symbol"},
                {99, "XCIX", "5th highest of basic symbol"}
        });
    }

    @Parameterized.Parameter
    public int arabicNumber;

    @Parameterized.Parameter(value = 1)
    public String romanNumeral;

    @Parameterized.Parameter(value = 2)
    public String message;

    @Before
    public void setUp() throws Exception {
        converter = new ArabicToRomanConverter();
    }

    @Test
    public void convert_should_return_empty_roman_numeral_when_input_is_zero() {
        String result = converter.convert(0);
        Assert.assertEquals("", result);
    }

    @Test
    public void convert_should_return_expected_roman_numeral_when_input_is_arabic() {
        String result = converter.convert(arabicNumber);
        Assert.assertEquals(message, romanNumeral, result);
    }
}