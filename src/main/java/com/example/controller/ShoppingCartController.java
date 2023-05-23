package com.example.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/shopping")
public class ShoppingCartController {
    @Autowired
    private HttpSession session;
    @Autowired
    private ServletContext application;

    @GetMapping("")
    @SuppressWarnings("unchecked")
    public String index(Model model) {
        List<Item> itemList = (List<Item>) application.getAttribute("itemList");
        if (itemList == null) {
            itemList = new LinkedList<>();
            itemList.add(new Item("手帳ノート", 1000));
            itemList.add(new Item("文房具セット", 1500));
            itemList.add(new Item("ファイル", 2000));
            application.setAttribute("itemList", itemList);
        }
        List<Item> itemCartList = (List<Item>) session.getAttribute("itemCartList");
        if (itemCartList == null) {
            itemCartList = new LinkedList<>();
            session.setAttribute("itemCartList", itemCartList);
        }
        int totalPrice = calculateTotalPrice(itemCartList);
        model.addAttribute("itemList", itemList);
        model.addAttribute("itemCartList", itemCartList);
        model.addAttribute("totalPrice", totalPrice);
        return "item-and-cart";
    }

    @PostMapping("/item")
    public String addToCart(String itemName) {
        List<Item> itemList = (List<Item>) application.getAttribute("itemList");
        List<Item> itemCartList = (List<Item>) session.getAttribute("itemCartList");
        for (Item item : itemList) {
            if (item.getName().equals(itemName)) {
                itemCartList.add(item);
                break;
            }
        }
        return "redirect:/shopping";
    }

    @PostMapping("/delete")
    public String removeFromCart(String itemName) {
        List<Item> itemCartList = (List<Item>) session.getAttribute("itemCartList");
        for (Item item : itemCartList) {
            if (item.getName().equals(itemName)) {
                itemCartList.remove(item);
                break;
            }
        }
        return "redirect:/shopping";
    }

    private int calculateTotalPrice(List<Item> itemCartList) {
        int totalPrice = 0;
        for (Item item : itemCartList) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}
