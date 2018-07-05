package com.iuminov;

import com.iuminov.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MainServlet extends HttpServlet {

    private static final Map<Request, Controller> controllerMap = new HashMap<>();

    @Override
    public void init() throws ServletException {
        controllerMap.put(new Request("GET", "/servlet/categories"), Factory.getAllCategoriesController());
        controllerMap.put(new Request("GET", "/servlet/category"), Factory.getCategoryById());
        controllerMap.put(new Request("POST", "/servlet/signup"), Factory.getSignUpController());
        controllerMap.put(new Request("GET", "/servlet/signup"), processView().apply("signup"));
        controllerMap.put(new Request("POST", "/servlet/login"), Factory.getLoginController());
        controllerMap.put(new Request("GET", "/servlet/login"), processView().apply("login"));
        controllerMap.put(new Request("GET", "/servlet/profile"), processView().apply("profile"));
        controllerMap.put(new Request("GET", "/servlet/logout"), this::processLogout);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>Hello from Servlet!</h1>");ё
        writer.println("</body>");
        writer.println("</html>");*/
        processRequest(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Request request = new Request(req.getMethod(), req.getRequestURI());

        controllerMap.getOrDefault(request, processView().apply("404"))
                .process(req, resp);



        /*if (req.getMethod().equals("GET")) {
            if (req.getRequestURI().equals("/servlet/home")) {
                req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
            } else if (req.getRequestURI().equals("/servlet/params")) {
                processParams(req, resp);
            } else if (req.getRequestURI().equals("/servlet/login")) {
                req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/views/404.jsp").forward(req, resp);
            }
        } else if (req.getMethod().equals("POST")) {
            if (req.getRequestURI().equals("/servlet/login")) {
                processLogin(req, resp);
            }
        } else {
            req.getRequestDispatcher("/WEB-INF/views/404.jsp").forward(req, resp);
        }*/
    }

    /*private void process404(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/WEB-INF/views/404.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }*/

    private void processSignUp(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/WEB-INF/vies/signup/404.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void processLogout(HttpServletRequest req, HttpServletResponse resp) {
        final String COOKIES_NAME = "MyApp";
        Cookie[] cookies = req.getCookies();

        for (Cookie c : cookies) {
            if (c.getName().equals(COOKIES_NAME)) {
                Cookie nullCookie = new Cookie(COOKIES_NAME, null);
                resp.addCookie(nullCookie);
                break;
            }
        }

        try {
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /*private Consumer<String> process404(HttpServletRequest req, HttpServletResponse resp) {
        return x -> {
            try {
                req.getRequestDispatcher(String.format("/WEB-INF/%s/404.jsp", x)).forward(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        };
    }*/

    private Function<String, Controller> processView() {
        return x -> (req, resp) -> {
            try {
                req.getRequestDispatcher(String.format("/WEB-INF/views/%s.jsp", x)).forward(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        };
    }

    /*private void processParams(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();
        String response = params.entrySet().stream()
                .flatMap(e -> Arrays.stream(e.getValue()))  // можно Stream.of(e.getValue())
                .reduce("params: ", (v1, v2) -> v1 + ", " + v2);

        req.setAttribute("parameters", response);

        req.getRequestDispatcher("/WEB-INF/views/params.jsp").forward(req, resp);
    }

    private void processLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("username", req.getParameter("username"));
        req.setAttribute("password", req.getParameter("password"));

        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }*/
}
