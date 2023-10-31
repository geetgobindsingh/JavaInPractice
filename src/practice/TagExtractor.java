package practice;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TagExtractor {
    public static void main(String[] args) {
        String input = "            systags.Add(new SysTag(\"sys.volt\",\"System Voltage\", true, 120.0 ,0.0, 600.0));\n" +
                "            systags.Add(new SysTag(\"sys.freq\", \"System Frequency\",true, 60.0, 45.0, 65.0));\n" +
                "            systags.Add(new SysTag(\"sys.phases\", \"System Phases\",true, 2.0, 1.0, 3.0));\n" +
                "            systags.Add(new SysTag(\"sys.gen.pwr\",\"sys.gen.pwr\", true, 0.0 ,0.0, 1.0));\n" +
                "            systags.Add(new SysTag(\"sys.ct.scale\" , \"CT Ratio\", true,1.0, 0.0 ,1.0));\n" +
                "            systags.Add(new SysTag(\"sys.pt.scale\",\"PT Ratio\", true, 1.0, 0.0 ,1.0));\n" +
                "            systags.Add(new SysTag(\"sys.ts.delay\",\"TS Delay\",true, 0.0, 0.0, 10.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.1.volt.undr.drop\",\"Source 1 Undervoltage Dropout\",true, 0.7, 0.0 ,1.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.1.volt.undr.pick\",\"Source 1 Undervoltage Pickup\",true, 0.8 ,0.0 ,1.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.1.volt.undr.delay\", \"Source 1 Undervoltage Delay\", true, 0.0, 0.0, 10.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.1.volt.over.drop\", \"Source 1 Overvoltage Dropout\", true, 1.2, 1.0, 2.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.1.volt.over.pick\", \"Source 1 Overvoltage Pickup\", true, 1.150000, 1.0, 2.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.1.volt.over.delay\", \"Source 1 Overvoltage Delay\", true, 0.0, 0.0, 10.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.1.volt.unbal.drop\", \"Source 1 Unbalancedvoltage Dropout\", true, 0.2, 0.0, 1.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.1.volt.unbal.pick\", \"Source 1 Unbalancedvoltage Pickup\", true, 0.150000, 0.0, 1.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.1.volt.unbal.delay\", \"Source 1 Unbalancedvoltage Delay\", true, 0.0, 0.0, 10.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.1.freq.undr.drop\", \"Source 1 Underfrequency Dropout\", true, 0.7, 0.0, 1.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.1.freq.undr.pick\", \"Source 1 Underfrequency Pickup\", true, 0.9, 0.0, 1.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.1.freq.undr.delay\", \"Source 1 Underfrequency Delay\", true, 0.0, 0.0, 10.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.1.freq.over.drop\", \"Source 1 Overfrequency Dropout\", true, 1.2, 1.0, 2.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.1.freq.over.pick\", \"Source 1 Overfrequency Pickup\", true, 1.150000, 1.0, 2.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.1.freq.over.delay\", \"Source 1 Overfrequency Delay\", true, 0.0, 0.0, 10.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.2.volt.undr.drop\", \"Source 2 UnderVoltage Dropout\", true, 0.7, 0.0, 1.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.2.volt.undr.pick\", \"Source 2 UnderVoltage Dropout\", true, 0.8, 0.0, 1.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.2.volt.undr.delay\", \"Source 2 UnderVoltage Delay\", true, 0.0, 0.0, 10.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.2.volt.over.drop\", \"Source 2 OverVoltage Dropout\", true, 1.2, 1.0, 2.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.2.volt.over.pick\", \"Source 2 OverVoltage Pickup\", true, 1.150000, 1.0, 2.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.2.volt.over.delay\", \"Source 2 OverVoltage Delay\", true, 0.0, 0.0, 10.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.2.volt.unbal.drop\", \"Source 2 UnbalancedVoltage Dropout\", true, 0.2, 0.0, 1.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.2.volt.unbal.pick\", \"Source 2 UnbalancedVoltage Pickup\", true, 0.150000, 0.0, 1.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.2.volt.unbal.delay\", \"Source 2 UnbalancedVoltage Delay\", true, 0.0, 0.0, 10.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.2.freq.undr.drop\", \"Source 2 Underfrequency Dropout\", true, 0.7, 0.0, 1.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.2.freq.undr.pick\", \"Source 2 Underfrequency Pickup\", true, 0.9, 0.0, 1.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.2.freq.undr.delay\", \"Source 2 Underfrequency Delay\", true, 0.0, 0.0, 10.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.2.freq.over.drop\", \"Source 2 Overfrequency Dropout\", true, 1.2, 1.0, 2.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.2.freq.over.pick\", \"Source 2 Overfrequency Pickup\", true, 1.150000, 1.0, 2.0));\n" +
                "            systags.Add(new SysTag(\"stp.vsrc.2.freq.over.delay\", \"Source 2 Overfrequency Delay\", true, 0.0, 0.0, 10.0));\n" +
                "            systags.Add(new SysTag(\"stp.load.volt.black.drop\", \"Load Voltage Blackout Dropout\", true, 0.2, 0.0, 1.0));\n" +
                "            systags.Add(new SysTag(\"stp.load.volt.black.pick\", \"Load Voltage Blackout Pickup\", true, 0.3, 0.0, 1.0));\n" +
                "            systags.Add(new SysTag(\"stp.load.volt.black.delay\", \"Load Voltage Blackout Delay\", true, 0.0, 0.0, 10.0));\n" +
                "            systags.Add(new SysTag(\"stp.alm.onsrc.delay\", \"Alarm On Source Delay\", true, 2.0, 0.0, 10.0));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.1.an\", true, 0, 0, 1000, 0, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.1.bn\", true, 0, 0, 1000, 0, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.1.cn\", true, 0, 0, 1000, 0, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.1.ne\", true, 0, 0, 1000, 0, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.1.ab\", true, 0, 0, 1000, 450, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.1.bc\", true, 0, 0, 1000, 0, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.1.ca\", true, 0, 0, 1000, 0, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.1.v1\", true, 0, 0, 1000, 0, false, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.1.v2\", true, 0, 0, 1000, 0, false, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.1.v0\", true, 0, 0,1000, 0, false, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.2.an\", true, 0, 0, 1000, 0, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.2.bn\", true, 0, 0, 1000, 0, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.2.cn\", true, 0, 0, 1000, 0, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.2.ne\", true, 0, 0, 1000, 0, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.2.ab\", true, 0, 0, 1000, 320, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.2.bc\", true, 0, 0, 1000, 0, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.2.ca\", true, 0, 0, 1000, 0, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.2.v1\", true, 0, 0, 1000, 0, false, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.2.v2\", true, 0, 0, 1000, 0, false, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.2.v0\", true, 0, 0, 1000, 0, false, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vload.an\", true, 0, 0, 1000, 0, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vload.bn\", true, 0, 0, 1000, 0, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vload.cn\", true, 0, 0, 1000, 0, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vload.ne\", true, 0, 0, 1000, 0, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vload.ab\", true, 0, 0, 1000, 160, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vload.bc\", true, 0, 0, 1000, 0, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vload.ca\", true, 0, 0, 1000, 0, true, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vload.v1\", true, 0, 0, 1000, 0, false, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vload.v2\", true, 0, 0, 1000, 0, false, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vload.v0\", true, 0, 0, 1000, 0, false, \"V\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.iload.a\", true, 0, 0, 1000, 0, true, \"A\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.iload.b\", true, 0, 0, 1000, 0, true, \"A\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.iload.c\", true, 0, 0, 1000, 0, true, \"A\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.iload.n\", true, 0, 0, 1000, 0, true, \"A\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.iload.i1\", true, 0, 0, 1000, 0, false, \"A\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.iload.i2\", true, 0, 0, 1000, 0, false, \"A\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.iload.i0\", true, 0, 0, 1000, 0, false, \"A\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.pload.appt.a\", true, 0, 0, 1000, 0, true, \"kW\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.pload.appt.b\", true, 0, 0, 1000, 0, true, \"kW\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.pload.appt.c\", true, 0, 0, 1000, 0, true, \"kW\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.pload.appt.tot\", true, 0, 0, 1000, 0, true, \"kW\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.pload.real.a\", true, 0, 0, 1000, 0, true, \"kW\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.pload.real.b\", true, 0, 0, 1000, 0, true, \"kW\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.pload.real.c\", true, 0, 0, 1000, 0, true, \"kW\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.pload.real.tot\", true, 0, 0, 1000, 0, true, \"kW\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.1.freq\", true, 0, 0, 1000, 0, false, \"Hz\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.1.phase\", true, 0, 0, 1000, 0, false, \"Rad\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.2.freq\", true, 0, 0, 1000, 0, false, \"Hz\"));\n" +
                "            anatags.Add(new AnaTag(\"msr.vsrc.2.phase\", true, 0, 0, 1000, 0, false, \"Rad\"));\n" +
                "            booltags.Add(new BoolTag(\"tip.switch.onsrc.1\", \"Source 1 Tripped\", true, false, false, false));\n" +
                "            booltags.Add(new BoolTag(\"tip.switch.onsrc.2\", \"Source 2 Tripped\", true, false, false, false));\n" +
                "            booltags.Add(new BoolTag(\"tip.test.req\", \"Test Required\", true, false, false, false));\n" +
                "            booltags.Add(new BoolTag(\"tip.discon.req\", \"Service Active\", true, false, false, false));\n" +
                "            booltags.Add(new BoolTag(\"tip.breaker.1.trip\", \"Breaker 1 Tripped\", true, false, false, false));\n" +
                "            booltags.Add(new BoolTag(\"tip.breaker.2.trip\", \"Breaker 2 Tripped\", true, false, false, false));\n" +
                "            alarmtags.Add(new BoolTag(\"trp.src.1.volt.undr\", \"Source 1 Undervoltage\", true, false, false, false));\n" +
                "            alarmtags.Add(new BoolTag(\"trp.src.1.volt.over\", \"Source 1 Overvoltage\", true, false, false, false));\n" +
                "            alarmtags.Add(new BoolTag(\"trp.src.1.volt.unbal\", \"Source 1 Unbalancedvoltage\", true, false, false, false));\n" +
                "            alarmtags.Add(new BoolTag(\"trp.src.1.freq.undr\", \"Source 1 Underfreq\", true, false, false, false));\n" +
                "            alarmtags.Add(new BoolTag(\"trp.src.1.freq.over\", \"Source 1 Overfreq\", true, false, false, false));\n" +
                "            alarmtags.Add(new BoolTag(\"trp.src.1.any\", \"Source 1 Any\", true, false, false, false));\n" +
                "            alarmtags.Add(new BoolTag(\"trp.src.2.volt.undr\", \"Source 2 Undervoltage\", true, false, false, false));\n" +
                "            alarmtags.Add(new BoolTag(\"trp.src.2.volt.over\", \"Source 2 Overvoltage\", true, false, false, false));\n" +
                "            alarmtags.Add(new BoolTag(\"trp.src.2.volt.unbal\", \"Source 2 Unbalancedvoltage\", true, false, false, false));\n" +
                "            alarmtags.Add(new BoolTag(\"trp.src.2.freq.undr\", \"Source 2 Underfreq\", true, false, false, false));\n" +
                "            alarmtags.Add(new BoolTag(\"trp.src.2.freq.over\", \"Source 2 Overfreq\", true, false, false, false));\n" +
                "            alarmtags.Add(new BoolTag(\"trp.src.2.any\", \"Source 2 Any\", true, false, false, false));\n" +
                "            alarmtags.Add(new BoolTag(\"trp.load.volt.black\", \"Load Blackvoltage\", true, false, false, false));\n" +
                "            alarmtags.Add(new BoolTag(\"trp.shed\", \"Load Shed\", true, false, false, false));\n" +
                "            booltags.Add(new BoolTag(\"tip.source.1.available\", \"Source 1 Available\", true, false, false, false));\n" +
                "            booltags.Add(new BoolTag(\"tip.source.2.available\", \"Source 2 Available\", true, false, false, false));\n" +
                "            booltags.Add(new BoolTag(\"tip.load.available\", \"Load Available\", true, false, false, false));\n" +
                "            tmrtags.Add(new TimerTag(\"tmr.util.rtn\", \"Utility Rtn\", \"dly.util.rtn\",0, true));\n" +
                "tmrtags.Add(new TimerTag( \"tmr.gen.start\", \"Gen Start\",\"dly.gen.start\" ,0, true));\n" +
                "tmrtags.Add(new TimerTag(\"tmr.gen.warm\", \"Gen Warm\",\"dly.gen.warm\", 0, true));\n" +
                "tmrtags.Add(new TimerTag(\"tmr.gen.cool\", \"Gen Cool\",\"dly.gen.cool\", 0, true));\n" +
                "tmrtags.Add(new TimerTag( \"tmr.gen.muststart\", \"Gen Must Start\",\"dly.gen.muststart\" ,0, false));\n" +
                "tmrtags.Add(new TimerTag( \"tmr.xfr.pre\", \"xfr pre\",\"dly.xfr.pre\" ,0, false));\n" +
                "tmrtags.Add(new TimerTag(\"tmr.xfr.find\", \"xfr find\", \"dly.xfr.find\", 0, false));\n" +
                "tmrtags.Add(new TimerTag(\"tmr.xfr.neut\", \"xfr neut\", \"dly.xfr.neut\", 0, false));\n" +
                "tmrtags.Add(new TimerTag(\"tmr.xfr.post\", \"xfr post\", \"dly.xfr.post\", 0, false));\n" +
                "tmrtags.Add(new TimerTag(\"tmr.xfr.fail\", \"xfr fail\", \"dly.xfr.fail\", 0, false));\n" +
                "tmrtags.Add(new TimerTag(\"tmr.sync.wait\", \"xfr wait\", \"dly.sync.wait\", 0, false)); \n" +
                "tmrtags.Add(new TimerTag(\"tmr.shed.init\", \"Load Shed Init\", \"dly.shed.init\",0, false));\n" +
                "tmrtags.Add(new TimerTag(\"tmrtags.shed.unshed\", \"Load Shed Unshed\", \"dly.tmrtags.shed.unshed\", 0, false));";

        List<String> tagsList = getTags(input);
        Scanner sc = new Scanner(System.in);
        List<String> foundList = new ArrayList();
        for (int i = 0; i < 120; i++) {
            foundList.add(sc.nextLine());
        }
//        for (String tag : tagsList) {
//            System.out.println("\"" + tag + "\""+", ");
//        }

        for (String tag : tagsList) {
            if (!foundList.contains(tag)) {
                System.out.println("\"" + tag + "\"" + ", ");
            }
        }
    }

    private static List<String> getTags(String input) {
        List<String> tags = new ArrayList<>();
        int count = 0;
        String[] arr = input.split("\n");
        for (int i = 0; i < arr.length; i++) {
            String reduced = arr[i].substring(arr[i].indexOf("\""));
            tags.add(reduced.split("\"")[1]);
        }
        return tags;
    }
}
