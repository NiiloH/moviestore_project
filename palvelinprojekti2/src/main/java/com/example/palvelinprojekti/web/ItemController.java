package com.example.palvelinprojekti.web;



import com.example.palvelinprojekti.domain.Item;
import com.example.palvelinprojekti.domain.ItemRepository;
import com.example.palvelinprojekti.domain.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Optional;


@ComponentScan(basePackages ={"com.example.palvelinprojekti.web"})
@Controller
public class ItemController {

    @Autowired
    private ItemRepository repository;

    @Autowired
    private CategoryRepository drepository;

    //LOG IN with user/admin

    @RequestMapping("/login")
    public String login(){
        return "login";
    }


    //MOVIE LIST

    @RequestMapping("/itemlist")
    public String itemList(Model model){
        model.addAttribute("items", repository.findAll());
        return "itemlist";
    }

    @RequestMapping(value = "/items")
    public @ResponseBody
    List<Item> itemListRest() {
        return (List<Item>) repository.findAll();
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Item> findItemRest(@PathVariable("id") Long itemId) {
        return repository.findById(itemId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)

    public String deleteItem(@PathVariable("id")Long itemid, Model model){
        repository.deleteById(itemid);
        return "redirect:../itemlist";
    }
    //INSERTING NEW MOVIE; SAVE & EDITING

    @RequestMapping(value = "/additem")
    public String addItem(Model model) {
       model.addAttribute("item", new Item() );
        model.addAttribute("categories", drepository.findAll());
        return "additem";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveItem(Item item) {
        repository.save(item);
        return "redirect:itemlist";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editItem(@PathVariable("id")Long itemid, Model model) {
        model.addAttribute("item", repository.findById(itemid));
        model.addAttribute("categories", drepository.findAll());
        return "edititem";
    }




}
