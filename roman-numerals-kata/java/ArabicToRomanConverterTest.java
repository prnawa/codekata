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
                {1, "I"},
                {5, "V"},
                {10, "X"},
                {50, "L"},
                {100, "C"},
                {500, "D"},
                {1000, "M"},

                {2, "II"},
                {6, "VI"},
                {11, "XI"},
                {51, "LI"},
                {101, "CI"},
                {501, "DI"},


                {3, "III"},
                {7, "VII"},
                {12, "XII"},
                {52, "LII"},
                {102, "CII"},
                {502, "DII"},


                {4, "IV"},
                {8, "VIII"},
                {13, "XIII"},
                {53, "LIII"},
                {103, "CIII"},
                {503, "DIII"},


                {9, "IX"},
                {14, "XIV"},
                {54, "LIV"},
                {104, "CIV"},
                {504, "DIV"},


                {15, "XV"},
                {55, "LV"},
                {105, "CV"},
                {505, "DV"},


                {16, "XVI"},
                {56, "LVI"},
                {106, "CVI"},
                {506, "DVI"},


                {17, "XVII"},
                {57, "LVII"},
                {107, "CVII"},
                {507, "DVII"},


                {18, "XVIII"},
                {58, "LVIII"},
                {108, "CVIII"},
                {508, "DVIII"},


                {19, "XIX"},
                {59, "LIX"},
                {109, "CIX"},
                {509, "DIX"},


                {20, "XX"},
                {60, "LX"},
                {110, "CX"},
                {510, "DX"},


                {21, "XXI"},
                {61, "LXI"},
                {111, "CXI"},
                {511, "DXI"},


                {22, "XXII"},
                {62, "LXII"},
                {112, "CXII"},
                {512, "DXII"},

                {90, "XC"},
                {91, "XCI"},
                {99, "XCIX"}
        });
    }

    @Parameterized.Parameter
    public int arabicNumber;

    @Parameterized.Parameter(value = 1)
    public String romanNumeral;


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
        Assert.assertEquals(romanNumeral, result);
    }
}