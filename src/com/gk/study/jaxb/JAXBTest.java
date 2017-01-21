package com.gk.study.jaxb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Assert;

import com.gk.study.jaxb.Team.Players;
import com.gk.study.jaxb.Team.Players.Player;

public class JAXBTest {
	
	public static void main(String args[]){
		
		useXsdGeneratedClasses();
		createXmlFileUsingXsdGeneratedClasses();
		
		JAXBTest test = new JAXBTest();
		test.readXmlFileUsingXsdGeneratedClasses();
		
	}
	
	
	private  void readXmlFileUsingXsdGeneratedClasses(){
		try {
			final JAXBContext jaxbContext = JAXBContext.newInstance("com.gk.study.jaxb");
			final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			final Team team =(Team)unmarshaller.unmarshal(getClass().getResourceAsStream("/team.xml"));
			
			Assert.assertEquals(2, team.getPlayers().getPlayer().size());
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void createXmlFileUsingXsdGeneratedClasses(){
		
		ObjectFactory objFact = new ObjectFactory();
		
		Team team = objFact.createTeam();
		Players players = objFact.createTeamPlayers();		
		Player player = objFact.createTeamPlayersPlayer();
		
		player.setName("Gopi");
		player.setPosition("Striker");
		players.getPlayer().add(player);
		team.setPlayers(players);
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("com.gk.study.jaxb");
			
			final Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(team, new FileOutputStream("team.xml"));
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
	}
	
	private static void useXsdGeneratedClasses(){
		
		Team team = new Team();
		team.setName("My Team");
		//team.setDateFounded(value);
		
		final Team.Players players = new Team.Players();
		final Team.Players.Player p1 = new Team.Players.Player();
		p1.setName("Gop");
		p1.setPosition("Striker");
		
		final Team.Players.Player p2 = new Team.Players.Player();
		p2.setName("Paru");
		p2.setPosition("MidField");
		
		players.getPlayer().add(p1);
		players.getPlayer().add(p2);
		
		team.setPlayers(players);
		
		final String position = team.getPlayers().getPlayer().get(0).getPosition();
		Assert.assertEquals("Striker", position);
	}
	
	

}
