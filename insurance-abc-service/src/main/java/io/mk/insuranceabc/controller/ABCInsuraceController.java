package io.mk.insuranceabc.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mk.insuranceabc.model.Insurer;

/**
 * 
 * @author a.m.manojkumar@gmail.com
 * 
 */
@RestController
@RequestMapping("abcinsurance")
public class ABCInsuraceController {

	static Map<String, Insurer> insMap = new HashMap<>();

	@RequestMapping("detail/{brand}/{model}")
	public Insurer getDetail(@PathVariable String brand, @PathVariable String model) {
		if (brand == null || model == null) {
			return null;
		}

		String key = brand.toLowerCase() + model.toLowerCase();
		if (!insMap.containsKey(key)) {
			Insurer ins = new Insurer();
			ins.setCompanyName("ABC");
			ins.setBrand(brand);
			ins.setModel(model);
			Random ran = new Random();
			int amt = ran.nextInt(12000);
			amt = amt < 4000 ? 8000 - amt : amt;
			ins.setInsuranceAmount(amt);
			ins.setIdv(amt * 12);
			insMap.put(key, ins);
		}
		return insMap.get(brand.toLowerCase() + model.toLowerCase());
	}
}
