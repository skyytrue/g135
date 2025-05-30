package kz.project.g135.controller;


//import kz.project.g135.db.*;
//import kz.project.g135.db.DBManager;
import kz.project.g135.model.Book;
//import kz.project.g135.model.Car;
import kz.project.g135.repository.BookRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class    HomeController {

    private final BookRepository bookRepository;

    @GetMapping(value="/")
    public String mainPage(Model model) {

//        List<Book> books=bookRepository.findAll();

        model.addAttribute("books", bookRepository.findAll());
        return "index";

    }

    @GetMapping(value = "/details-book/{id}")
    public String detailsBook(@PathVariable Long id, Model model) {

        model.addAttribute("books", bookRepository.findById(id).get());
        return "details-book";
    }

    @PostMapping(value = "/update-book")
    public String updateBook(Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }

    @PostMapping(value="/add-car")
    public String addCar(Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }

    @PostMapping(value="/delete-car")
    public String deleteCar(@RequestParam Long id) {
        bookRepository.deleteById(id);
        return "redirect:/";
    }


//    @GetMapping(value = "/")
//    public String mainPage(Model model){
//        model.addAttribute("mashinu", DBConnector.getAllCars());
//        return "index";
//    }
//
//    @PostMapping(value = "/add-car")
//    public String addCar(Car car){
//        DBConnector.addCar(car);
//        return "redirect:/";
//    }
//
//    @GetMapping(value = "/add-car")
//    public String addCarPage(Model model) {
//        model.addAttribute("mashinu", DBConnector.getAllCars());
//        return "add-car";
//    }
//
//    @GetMapping(value = "/details/{id}")
//    public String showDetailsCar(Model model, @PathVariable long id){
//        model.addAttribute("mashina", DBConnector.getCarById(id));
//        return "details-page";
//    }
//
//    @PostMapping(value = "/update-car")
//    public String updateCar(Car car){
//        DBConnector.updateCar(car);
//        return "redirect:/";
//    }
//
//    @PostMapping(value = "/delete-car")
//    public String deleteCar(@RequestParam long id){
//        DBConnector.deleteCar(id);
//        return "redirect:/";
//    }


}