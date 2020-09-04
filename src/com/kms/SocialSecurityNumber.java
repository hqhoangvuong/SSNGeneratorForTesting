package com.kms;

import java.util.Random;

public class SocialSecurityNumber
{
    private final int MIN_SSN = 1010001; // Smallest legal ssn
    private final int MAX_SSN = 799999999; // Biggest valid ssn
    private final int SERIAL_LENGTH = 4;   // Number of digits in serial part
    private final int GROUP_LENGTH = 2;    // Number of digits in group part
    private final int WHOLE_LENGTH = 9;   // Number of characters in entire ssn

    private StringBuffer whole;
    private Random random = new Random();

    public SocialSecurityNumber() {

    }

    public String GenerateInvaidSSNOutOfBound()
    {
        Integer rng_sama;

        int x = random.ints(0, 21).findFirst().getAsInt();

        if (x < 10)
        {
            rng_sama = random.ints(0, MIN_SSN).findFirst().getAsInt();
            StringBuilder _sb = new StringBuilder(rng_sama.toString());
            while(_sb.length() < WHOLE_LENGTH) {
                _sb.insert(0, "0");
            }
            return _sb.toString();
        }
        else
        {
            rng_sama = random.ints(MAX_SSN + 1, 1000000000).findFirst().getAsInt();
            return rng_sama.toString();
        }
    }

    public String GenerateInvaildSSN(boolean isAreaVaild, boolean isGroupVaild, boolean isSerialVaild)
    {
        StringBuilder _sb_ssn;

        StringBuilder _sb_area;
        StringBuilder _sb_group;
        StringBuilder _sb_serial;

        Integer area;    // First three digits: XXX-nn-nnnn
        Integer group;   // Nest two digits: nnn-XX-nnnn
        Integer serial;  // Last four digits: nnn-nn-XXXX

        if(isAreaVaild)
        {
            area = 666;
            while(area == 666)
                area = random.ints(1, 900).findFirst().getAsInt();
        }
        else
        {
            int x = random.ints(0, 16).findFirst().getAsInt();

            if (x < 5)
            {
                area = 0;
            }
            else if(x >= 5 && x < 10)
            {
                area = random.ints(900, 1000).findFirst().getAsInt();
            } else
            {
                area = 666;
            }
        }

        if(isGroupVaild)
        {
            group = random.ints(1, 100).findFirst().getAsInt();
        }
        else
        {
            group = 0;
        }

        if(isSerialVaild)
        {
            serial = random.ints(1, 10000).findFirst().getAsInt();
        }
        else
        {
            serial = 0;
        }

        _sb_area = new StringBuilder(area.toString());
        _sb_group = new StringBuilder(group.toString());
        _sb_serial = new StringBuilder(serial.toString());

        while(_sb_area.length() < 3) {
            _sb_area.insert(0, '0');
        }

        while (_sb_group.length() < 2) {
            _sb_group.insert(0, '0');
        }

        while (_sb_serial.length() < 4) {
            _sb_serial.insert(0, '0');
        }

        return _sb_area.toString() + _sb_group.toString() + _sb_serial.toString();
    }
}