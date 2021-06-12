package com.helixstack.projectDemo.util;

import java.io.PrintWriter;
import java.util.List;

import com.helixstack.projectDemo.model.ResponseObj;

public class CsvUtils {

	public static void downloadCsv(PrintWriter writer, List<ResponseObj> res) {
        writer.write("First Name, Last Name, Email, Company Name \n");
        for (ResponseObj item : res) {
            writer.write(item.getFirstName() + "," + item.getLastName() + "," + item.getEmail() + "," + item.getCompanyName() + "\n");
        }
    }
}
