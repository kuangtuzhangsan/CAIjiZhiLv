package com.xyx.switchCase;

import com.xyx.common.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class example1 {
    public static void main(String[] args) {
        switch ("XCJYRQ") {
            case "内部（全面）下次检验日期（电类定检)":
            case "内部(全面)下次检验日期(电类定检)":
            case "XCJYRQ":
            case "外部(年度)下次检验日期":
            case "锅炉水质检验日期":
            case "耐压试验_下次检验日期":
            case "下次检验日期":
                System.out.println("hello_world!");
                break;
            // 其他条件的处理...
            default:
                // 默认情况的处理...
                break;
        }
        System.out.println(System.currentTimeMillis());
        // 获取今年的天数
        int daysOfThisYear = LocalDate.now().lengthOfYear();
        // 获取指定某年的天数
        LocalDate.of(2012, 1, 1).lengthOfYear();
        System.out.println(daysOfThisYear);

        List<Student> studentList = null;
        // 报错，必须判断为空 的情况
        if (studentList.isEmpty()){
            System.out.println("9999");
        }
    }


}
