package com.sonda.cisco.controller;

import com.sonda.cisco.model.xml.MenuItem;
import com.sonda.cisco.model.xml.PhoneMenu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanCarlo on 11/05/2016.
 */
@Controller
@RequestMapping("/xml")
public class PhoneMenuController {

    @RequestMapping(value = "/menu/{titulo}", method = RequestMethod.GET)
    @ResponseBody
    public PhoneMenu getPhoneMenu(@PathVariable String titulo) {

        List<MenuItem> menuItems= new ArrayList<MenuItem>();


        PhoneMenu phoneMenu = new PhoneMenu();
        phoneMenu.setTitle(titulo);
        MenuItem menuItem =new MenuItem();
        menuItem.setName("name");
        menuItem.setUrl("Url");
        MenuItem menuItem2 =new MenuItem();
        menuItem2.setName("name");
        menuItem2.setUrl("Url");
        menuItems.add(menuItem);
        menuItems.add(menuItem2);
        phoneMenu.setMenuItems(menuItems);

        return phoneMenu;

    }


    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    @ResponseBody
    public PhoneMenu getPhoneMenu() {

        PhoneMenu phoneMenu = new PhoneMenu();
        return phoneMenu;

    }
}
