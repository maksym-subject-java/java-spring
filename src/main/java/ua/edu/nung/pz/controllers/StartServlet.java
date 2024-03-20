package ua.edu.nung.pz.controllers;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ua.edu.nung.pz.models.Firebase;
import ua.edu.nung.pz.models.User;
import ua.edu.nung.pz.views.IndexView;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import static ua.edu.nung.pz.models.User.USER_SESSION_KEY;


// loadOnStartup - створення під час запуску Tomcat
@WebServlet(name = "StartServlet", urlPatterns = "/*", loadOnStartup = 1)
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String context = "";
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute(USER_SESSION_KEY);
        String userName = user == null ? "" : user.getDisplayName();

        switch (request.getPathInfo()) {
            case "/contacts":
                context = "<h2>Our Contacts!</h2>\n";
                break;
            case "/login":
                context = "<h2>Login!</h2>\n";
                context += IndexView.getInstance().getLoginForm();
                break;
            case "/forgotpassword":
                context = "<h2>Restore Password!</h2>\n";
                break;
            default:
                context = "<h2>Hello World from Servlet!</h2>\n";
        }

        IndexView indexView = IndexView.getInstance();
        String header = indexView.getHeader(userName);

        String footer = indexView.getFooter("");
        String body = indexView.getBody(header, footer, context);


        out.println(IndexView.getInstance().getPage("Green Shop", body));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = null;

        User user = new User();
        user.setDisplayName("Bob");
        user.setEmail(email);
        user.setPassword(password);
        Firebase firebase = Firebase.getInstance();
        if (firebase.getUserByEmail(user.getEmail()).equals(Firebase.USER_EXISTS)) {
            String firebaseResponse = firebase.signInWithEmailAndPassword(user.getEmail(), user.getPassword());
            if (firebaseResponse.equals(Firebase.PASSWORD_OK)) {


                session = req.getSession();
                session.setAttribute(USER_SESSION_KEY, user);
                System.out.println(Firebase.PASSWORD_OK);
            } else {
                System.out.println("Wrong Password");
            }
            System.out.println("User Exist");
        } else {
            String userMsg = Firebase.getInstance().createUser(user);
            System.out.println(userMsg);
        }

        System.out.println(user);

        resp.sendRedirect("login");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        String path = getServletContext().getRealPath("html/");
        IndexView indexView = IndexView.getInstance();
        indexView.setPath(path);

        initFirebase();


//
//
//
//
//        final FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference ref = database.getReference("/");
//        DatabaseReference goodsRef = ref.child("Goods/");
//
//        Map<String, Object> data = new HashMap<>();
//        data.put("country", "Ukraine");
//        data.put("name", "Samsung S8");
//        data.put("price", 15999);
//        goodsRef.push().setValueAsync(data);
//
//        try {
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }


    }

    public void initFirebase() {


        Properties props = new Properties();
        InputStream is = getClass().getClassLoader().getResourceAsStream("app.properties");
        try {
            props.load(is);
        } catch (IOException e) {
            System.out.println("Error on init firebase " + e.getMessage());
            throw new RuntimeException(e);
        }
        Firebase firebase = Firebase.getInstance();
        firebase.setFirebaseConfigPath(props.getProperty("file.path"));
        firebase.setFirebaseName(props.getProperty("firebase.name"));
        firebase.setApiKey(props.getProperty("web.api.key"));
        firebase.setSignInUrl(props.getProperty("signInUrl"));
        firebase.init();
    }

}
