// mvn spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=8081'


package managment.model;

import java.sql.*;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.ArrayList;
@RestController
@RequestMapping("dynamic")
public class WebController {

    private String HOMEPAGE = "homepage";
    private String LOGIN = "login";
    private String MYREVIEW = "myReview";
    private String MOVIES = "movies";
    private String MOVIEREVIEWS = "moviesReviews";
    int userID;
    /*@GetMapping("/main")
    @ResponseBody
    public String helloEndpoint() {
        return "<html><body><h1>"
                    + new Random().nextInt(100) 
                    +"</h1></body></html>";
    }*/


    public WebController() {

    }





    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    //@GetMapping("/homepage")
    public ModelAndView homepage() {
        ModelAndView mv = new ModelAndView(LOGIN);

        mv.addObject("message", "Welcome to your homepage, " /*+ userName*/);
        return mv;
    }
    
    @GetMapping("/login")
    public ModelAndView login() {
        System.out.println("login()");

        ModelAndView mv = new ModelAndView(LOGIN);
        mv.addObject("message", "Please enter your username and click submit.");
        return mv;
    }
    @GetMapping("/loginError")
    public ModelAndView loginError() {
        System.out.println("loginError()");
        ModelAndView mv = new ModelAndView(LOGIN);
        mv.addObject("message", "Error during login. Please try again.");
        return mv;
    }



    @PostMapping(value = "/submitUsername")
    public String submitUsername(@ModelAttribute String userName) {
        System.out.println("submitUsername()");

        Connection myConnection = DataBaseUtil.getConnection();
        String query = "select UserName from User where userName = ?";
        PreparedStatement userStatement = null;



        ResultSet resultSet = null;
        try {
            userStatement = myConnection.prepareStatement(query);

            userStatement.setString(1, userName);
            System.out.println("0");
            System.out.println("username ->" + userName + "<-");

            resultSet = userStatement.executeQuery();
            System.out.println(resultSet);

            if (!resultSet.next()) {
                System.out.println("1");
                System.out.println("This is the result ->" + resultSet.getString(1) + "<-");

                return "redirect:/dynamic/loginError";
            } else {
                System.out.println("1.5");

                return "redirect:/dynamic/homepage";
            }
        } catch (SQLException e){
            System.out.println("3");

            if (resultSet != null) {
                try {
                    System.out.println("4");

                    resultSet.close();
                } catch (SQLException e1) {
                    System.out.println(e1);
                }
            }
            if (userStatement != null) {
                System.out.println("5");

                try {
                    System.out.println("6");

                    userStatement.close();
                } catch (SQLException e1) {
                    System.out.println(e1);
                }
            }
            System.out.println("7");

            return "redirect:/dynamic/loginError";
        }

        
    } // submitUsername

    /*@PostMapping("/submitform")
    public String page(@ModelAttribute Book book) {
        books.add(book);
        return "redirect:/dynamic/page";
    }*/


   /* @GetMapping("/myReviews")
    public ModelAndView myReviews(@RequestParam("id") int id) {
        ModelAndView mv = new ModelAndView(MYREVIEW);
        String query = "SELECT Movie.MovieName, Review.Stars, Review.ReviewText FROM Review JOIN Movie" +
                " ON Review.MovieID = Movie.MovieID JOIN User ON REVIEW.UserID = User.UserID WHERE User.UserID = " +
                id;
        List<String> reviewTexts = new ArrayList<>();
        Statement statement = myConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next() == true) {
            reviewText.add(resultSet.getString("MovieName") + "\"" +
                    resultSet.getString("reviewText" "\"");

        } // while
        mv.addObject("reviewTexts", reviewTexts);
        return mv;
    } // myReviews*/

    /*@GetMapping("/moviereviews")
    public ModelAndView myReviews(@RequestParam("id") int id) {
        ModelAndView mv = new ModelAndView(MOVIEREVIEWS);
        String query = "SELECT Movie.MovieName, Review.Stars, Review.ReviewText FROM Review JOIN Movie" +
                " ON Review.MovieID = Movie.MovieID WHERE User.UserID = " +
                id;
        List<String> reviewTexts = new ArrayList<>();
        Statement statement = myConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next() == true) {
            reviewText.add(resultSet.getString("MovieName") + "\"" +
                    resultSet.getString("reviewText") "\"");

        } // while
        mv.addObject("reviewTexts", reviewTexts);
        return mv;
    } // myReviews*/



}
