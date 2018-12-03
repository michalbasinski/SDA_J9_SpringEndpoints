package pl.sda.spring.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    Book bookSaved = new Book();

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addBook(@RequestBody Book book) {
        return new ResponseEntity(bookSaved, HttpStatus.OK);
    }


    @RequestMapping(path = "/title/{title}", method = RequestMethod.GET)
    public ResponseEntity findBookByTitle(@PathVariable String title) {
        return new ResponseEntity(bookSaved, HttpStatus.OK);
    }


    @RequestMapping(path = "/{author}", method = RequestMethod.GET)
    public ResponseEntity findBookByAuthor(@PathVariable String author) {
        return new ResponseEntity(bookSaved, HttpStatus.OK);
    }


    @RequestMapping(path = "/title/{title}/author/{author}", method = RequestMethod.GET)
    public ResponseEntity<String> findBookByTitleAndAuthor(@PathVariable("title") String title, @PathVariable("author") String author) {
        return new ResponseEntity("aaa", HttpStatus.OK);
    }

    private class Book {}
}
