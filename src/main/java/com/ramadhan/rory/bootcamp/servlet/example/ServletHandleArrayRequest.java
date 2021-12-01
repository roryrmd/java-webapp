package com.ramadhan.rory.bootcamp.servlet.example;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "servlet-handle-array", urlPatterns = {"/kirim-array"})
public class ServletHandleArrayRequest extends HttpServlet {
    //language=HTML
    String html = "<!doctype html>\n" +
            "<html lang='en'>\n" +
            "<head>\n" +
            "    <meta charset='UTF-8'>\n" +
            "    <meta name='viewport'\n" +
            "          content='width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0'>\n" +
            "    <meta http-equiv='X-UA-Compatible' content='ie=edge'>\n" +
            "    <title>Data Mahasiswa</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<table>\n" +
            "    <thead>\n" +
            "    <tr>\n" +
            "        <td>NIM</td>\n" +
            "        <td>Nama</td>\n" +
            "        <td>Kota</td>\n" +
            "        <td>tanggal Lahir</td>\n" +
            "        <td>Hobi</td>\n" +
            "    </tr>\n" +
            "    </thead>\n" +
            "    <tbody>\n" +
            "    <tr>\n" +
            "        <td>%s</td>\n" +
            "        <td>%s</td>\n" +
            "        <td>%s</td>\n" +
            "        <td>%s</td>\n" +
            "        <td>%s</td>\n" +
            "    </tr>\n" +
            "    </tbody>\n" +
            "</table>\n" +
            "</body>\n" +
            "</html>";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nim = req.getParameter("nim");
        String nama = req.getParameter("nama");
        String kota = req.getParameter("kota");
        String tanggalLahir = req.getParameter("tanggalLahir");
        String[] hobis = req.getParameterValues("hobi");

        log.info("Data HTTP POST: {nim: {}, nama: {}, kota: {}, tanggalLahir: {}, hobi: {}}",
                nim, nama, kota, tanggalLahir, hobis);

        String hobi = String.join(", ", hobis);

        resp.getWriter().print(String.format(html, nim, nama, kota, tanggalLahir, hobi));
    }
}
