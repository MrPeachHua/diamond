/**
 * 上海只二网络科技有限公司
 * <p>
 * Copyright (c) 2015-2025 Founder Ltd. All Rights Reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */

package com.fd.diamond.common.util;

import org.apache.pdfbox.io.RandomAccess;
import org.apache.pdfbox.io.RandomAccessBufferedFileInputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;
import java.util.List;
import java.util.ListIterator;

/**
 * @ClassName PDFUtil
 * @Description XXX
 * @Author hua
 * @Date 2021/6/1 18:37
 * @Version V1
 **/
public class PDFUtil {


    public static String getTextFromPDF(String pdfFilePath) throws Exception {
        String result = null;
        RandomAccessBufferedFileInputStream is = null;
        PDDocument document = null;
        PDFTextStripper stripper = new PDFTextStripper();
        document = PDDocument.load(new File(pdfFilePath));
        Splitter splitter = new Splitter();
        java.util.List<PDDocument> pages = splitter.split(document);
        ListIterator<PDDocument> iterator = pages.listIterator();

        String text = stripper.getText(document);
//        while (iterator.hasNext()) {
//            PDDocument pd = iterator.next();
//            String text = stripper.getText(pd);
//            System.out.println(text);
//        }
//        document.close();

        return result;
    }


    public static void main(String[] args) throws Exception {
        String url = "D:\\pdf\\20191210103617476.pdf";
        String textFromPDF = PDFUtil.getTextFromPDF(url);
        System.out.println(textFromPDF);
    }
}
