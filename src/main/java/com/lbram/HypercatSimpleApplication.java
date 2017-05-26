package com.lbram;

import com.lbram.data.entity.Item;
import com.lbram.data.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HypercatSimpleApplication {

	@Autowired
	private IItemService itemService;

	public static void main(String[] args) {
		SpringApplication.run(HypercatSimpleApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData() {
		return (args) -> {
		  itemService.deleteAll();
      itemService.save(new Item("localhost:8001/cat?href=https://144.76.238.39/Thingworx/Things/iTAC.SAMMobile.ServiceThing/Services/getMachineData?machineName=R1","Ist eine Maschine.."));
      itemService.save(new Item("localhost:8001/cat?href=https://144.76.238.39/Thingworx/Things/iTAC.SAMMobile.ServiceThing/Services/getMachineData?machineName=R2","Ist eine Maschine.."));
      itemService.save(new Item("localhost:8001/cat?href=https://144.76.238.39/Thingworx/Things/iTAC.SAMMobile.ServiceThing/Services/getMachineData?machineName=CMT1","Ist eine Maschine.."));
      itemService.save(new Item("localhost:8001/cat?href=https://144.76.238.39/Thingworx/Things/iTAC.SAMMobile.ServiceThing/Services/getMachineData?machineName=CMT2","Ist eine Maschine.."));
      itemService.save(new Item("localhost:8001/cat?href=https://144.76.238.39/Thingworx/Things/iTAC.SAMMobile.ServiceThing/Services/getMachineData?machineName=LFT1","Ist eine Maschine.."));
      itemService.save(new Item("localhost:8001/cat?href=https://144.76.238.39/Thingworx/Things/iTAC.SAMMobile.ServiceThing/Services/getMachineData?machineName=LFT2","Ist eine Maschine.."));
		};
	}
}
