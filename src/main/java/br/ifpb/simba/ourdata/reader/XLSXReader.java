/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.simba.ourdata.reader;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author kieckegard
 */
public class XLSXReader extends ExcelReader
{
    @Override
    public List<Sheet> build(String url){
        try{
            URL stackURL = new URL(url);
            URLConnection uc = stackURL.openConnection();
            XSSFWorkbook workbook = new XSSFWorkbook(uc.getInputStream());
            List<Sheet> sheets = new ArrayList<>();
            for(int i=0;i<workbook.getNumberOfSheets();i++){
                sheets.add(workbook.getSheetAt(i));
            }
            return sheets;
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
