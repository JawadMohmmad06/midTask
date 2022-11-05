package com.controller;

import com.domain.Variables;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.lang.Math;
@Controller
@RequestMapping("/tax")
public class TaxControll {
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @RequestMapping("/open")
    public String form(Model model) {
        Variables variables = new Variables();
        model.addAttribute("variables", variables);
        model.addAttribute("yearTax", "");
        model.addAttribute("monthTax", "");
        return "taxCalculator";
    }
public double taxible_salary(int basic_salary,int conveyance,int medical,int house_rent,int festibal)
{
    double taxble_inome=0;
    taxble_inome=taxble_inome+basic_salary;
    //convenyece
    if(conveyance>30000)
    {
    taxble_inome=taxble_inome+(conveyance-30000);}


    //house rent
    if(300000>basic_salary*0.5) {
        taxble_inome = taxble_inome +( house_rent - (basic_salary * 0.5));
    }
    else
    {
        taxble_inome = taxble_inome +Math.abs( 300000-house_rent);
    }
    System.out.println(taxble_inome);
    //medical
    if(basic_salary*0.1<120000)
    {
        taxble_inome=taxble_inome+medical-(basic_salary*0.1);
    }
    else
    {
        taxble_inome=taxble_inome+(medical-120000);
    }
    taxble_inome=taxble_inome+festibal;
    return taxble_inome;



}
    @RequestMapping("/calculator")
    public String calculator(@Valid @ModelAttribute("variables") Variables variables, BindingResult bindingResult, Model model) {
            if(bindingResult.hasErrors())
            {
                return "taxCalculator";
            }
            else
            {
                double tax=0;
                if(variables.getCategory()=='g') {
                    double tax_money = taxible_salary(Integer.parseInt(variables.getBasic_salary()) * 12, Integer.parseInt(variables.getCon()) * 12, Integer.parseInt(variables.getMedical()) * 12, Integer.parseInt(variables.getHouse_rent()) * 12, Integer.parseInt(variables.getFestival()) * 2);

                    tax_money=tax_money-300000;

                    if(tax_money>0)
                    {
                        double temp=tax_money-100000;
                        if(temp>=0)
                        {
                            tax=tax+5000;
                            tax_money=tax_money-100000;
                        }
                        else
                        {
                            tax=tax+(tax_money*0.05);
                            tax_money=tax_money-100000;
                        }
                    }

                    if(tax_money>0)
                    {
                        double temp=tax_money-300000;
                        if(temp>=0)
                        {
                            tax=tax+30000;
                            tax_money=tax_money-300000;
                        }
                        else
                        {
                            tax=tax+(tax_money*0.10);
                            tax_money=tax_money-300000;
                        }
                    }


                    if(tax_money>0)
                    {double temp=tax_money-400000;
                        if(temp>=0)
                        {
                            tax=tax+60000;
                            tax_money=tax_money-400000;
                        }
                        else
                        {
                            tax=tax+(tax_money*0.15);
                            tax_money=tax_money-400000;
                        }
                    }
                    if(tax_money>0)
                    {double temp=tax_money-500000;
                        if(temp>=0)
                        {
                            tax=tax+100000;
                            tax_money=tax_money-500000;
                        }
                        else
                        {
                            tax=tax+(tax_money*0.20);
                            tax_money=tax_money-500000;
                        }
                    }
                    if(tax_money>0)
                    {
                            tax=tax+(tax_money*0.25);


                    }
                    tax=tax-(Integer.parseInt(variables.getInvestment())*0.15);

                } else if (variables.getCategory()=='f') {
                    double tax_money = taxible_salary(Integer.parseInt(variables.getBasic_salary()) * 12, Integer.parseInt(variables.getCon()) * 12, Integer.parseInt(variables.getMedical()) * 12, Integer.parseInt(variables.getHouse_rent()) * 12, Integer.parseInt(variables.getFestival()) * 2);
                    System.out.println(tax_money);
                    tax_money=tax_money-350000;

                    if(tax_money>0)
                    {
                        double temp=tax_money-100000;
                        if(temp>=0)
                        {
                            tax=tax+5000;
                            tax_money=tax_money-100000;
                        }
                        else
                        {
                            tax=tax+(tax_money*0.05);
                            tax_money=tax_money-100000;
                        }
                    }

                    if(tax_money>0)
                    {
                        double temp=tax_money-300000;
                        if(temp>=0)
                        {
                            tax=tax+30000;
                            tax_money=tax_money-300000;
                        }
                        else
                        {
                            tax=tax+(tax_money*0.10);
                            tax_money=tax_money-300000;
                        }
                    }


                    if(tax_money>0)
                    {double temp=tax_money-400000;
                        if(temp>=0)
                        {
                            tax=tax+60000;
                            tax_money=tax_money-400000;
                        }
                        else
                        {
                            tax=tax+(tax_money*0.15);
                            tax_money=tax_money-400000;
                        }
                    }
                    if(tax_money>0)
                    {double temp=tax_money-500000;
                        if(temp>=0)
                        {
                            tax=tax+100000;
                            tax_money=tax_money-500000;
                        }
                        else
                        {
                            tax=tax+(tax_money*0.20);
                            tax_money=tax_money-500000;
                        }
                    }
                    if(tax_money>0)
                    {
                        tax=tax+(tax_money*0.25);


                    }
                    tax=tax-(Integer.parseInt(variables.getInvestment())*0.15);

                }
                else if (variables.getCategory()=='d') {
                    double tax_money = taxible_salary(Integer.parseInt(variables.getBasic_salary()) * 12, Integer.parseInt(variables.getCon()) * 12, Integer.parseInt(variables.getMedical()) * 12, Integer.parseInt(variables.getHouse_rent()) * 12, Integer.parseInt(variables.getFestival()) * 2);

                    tax_money=tax_money-450000;

                    if(tax_money>0)
                    {
                        double temp=tax_money-100000;
                        if(temp>=0)
                        {
                            tax=tax+5000;
                            tax_money=tax_money-100000;
                        }
                        else
                        {
                            tax=tax+(tax_money*0.05);
                            tax_money=tax_money-100000;
                        }
                    }

                    if(tax_money>0)
                    {
                        double temp=tax_money-300000;
                        if(temp>=0)
                        {
                            tax=tax+30000;
                            tax_money=tax_money-300000;
                        }
                        else
                        {
                            tax=tax+(tax_money*0.10);
                            tax_money=tax_money-300000;
                        }
                    }


                    if(tax_money>0)
                    {double temp=tax_money-400000;
                        if(temp>=0)
                        {
                            tax=tax+60000;
                            tax_money=tax_money-400000;
                        }
                        else
                        {
                            tax=tax+(tax_money*0.15);
                            tax_money=tax_money-400000;
                        }
                    }
                    if(tax_money>0)
                    {double temp=tax_money-500000;
                        if(temp>=0)
                        {
                            tax=tax+100000;
                            tax_money=tax_money-500000;
                        }
                        else
                        {
                            tax=tax+(tax_money*0.20);
                            tax_money=tax_money-500000;
                        }
                    }
                    if(tax_money>0)
                    {
                        tax=tax+(tax_money*0.25);


                    }
                    tax=tax-(Integer.parseInt(variables.getInvestment())*0.15);

                }
                else if (variables.getCategory()=='e') {
                    double tax_money = taxible_salary(Integer.parseInt(variables.getBasic_salary()) * 12, Integer.parseInt(variables.getCon()) * 12, Integer.parseInt(variables.getMedical()) * 12, Integer.parseInt(variables.getHouse_rent()) * 12, Integer.parseInt(variables.getFestival()) * 2);

                    tax_money=tax_money-475000;

                    if(tax_money>0)
                    {
                        double temp=tax_money-100000;
                        if(temp>=0)
                        {
                            tax=tax+5000;
                            tax_money=tax_money-100000;
                        }
                        else
                        {
                            tax=tax+(tax_money*0.05);
                            tax_money=tax_money-100000;
                        }
                    }

                    if(tax_money>0)
                    {
                        double temp=tax_money-300000;
                        if(temp>=0)
                        {
                            tax=tax+30000;
                            tax_money=tax_money-300000;
                        }
                        else
                        {
                            tax=tax+(tax_money*0.10);
                            tax_money=tax_money-300000;
                        }
                    }


                    if(tax_money>0)
                    {double temp=tax_money-400000;
                        if(temp>=0)
                        {
                            tax=tax+60000;
                            tax_money=tax_money-400000;
                        }
                        else
                        {
                            tax=tax+(tax_money*0.15);
                            tax_money=tax_money-400000;
                        }
                    }
                    if(tax_money>0)
                    {double temp=tax_money-500000;
                        if(temp>=0)
                        {
                            tax=tax+100000;
                            tax_money=tax_money-500000;
                        }
                        else
                        {
                            tax=tax+(tax_money*0.20);
                            tax_money=tax_money-500000;
                        }
                    }
                    if(tax_money>0)
                    {
                        tax=tax+(tax_money*0.25);


                    }
                    if(Integer.parseInt(variables.getInvestment())>0) {
                        tax = tax - (Integer.parseInt(variables.getInvestment()) * 0.15);
                    }
                }


                model.addAttribute("yearTax", String.format("%.2f",tax));
                model.addAttribute("monthTax", String.format("%.2f",tax/12));
                return "taxCalculator";
            }




    }
}
