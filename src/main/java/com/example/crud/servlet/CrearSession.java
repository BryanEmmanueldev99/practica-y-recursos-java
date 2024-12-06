package com.example.crud.servlet;

import java.io.IOException;

import com.example.crud.dto.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CrearSession")
public class CrearSession extends HttpServlet {
       
      private static final long serial = 1L;

      public void session_start(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           HttpSession miSession = request.getSession(true);
           Producto nuevoProducto = new Producto(1, "Libro de programación en Java.", 500);
           miSession.setAttribute("producto", nuevoProducto);
           System.out.println("Holaaaaa");
      }

    //    public void callbalck_session(HttpServletRequest request, HttpServletResponse response) {
    //          this.session_start();
    //    }

}
