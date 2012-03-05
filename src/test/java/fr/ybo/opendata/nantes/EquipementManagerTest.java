package fr.ybo.opendata.nantes;

import static junit.framework.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;

import fr.ybo.opendata.nantes.modele.Categorie;
import fr.ybo.opendata.nantes.modele.Equipement;
import fr.ybo.opendata.nantes.modele.Theme;
import fr.ybo.opendata.nantes.modele.Type;
import fr.ybo.opendata.nantes.util.EquipementManager;

public class EquipementManagerTest {

	/**
	 * Constructeur de openDataApi.
	 */
	@Before
	public void setup() {
		Guice.createInjector(new AbstractModule() {
			protected void configure() {
				requestStaticInjection(EquipementManager.class);
			}
		});
	}
	
	/**
	 * Test qui permet de s'assurer que l'ensemble des types
	 * d'équipements sont couverts.
	 */
	@Test
	public void testUnknown() {
		Map<Integer, Equipement> map = EquipementManager.getInstance()
				.getMapEquipements();
		
		for (Equipement eq : map.values()) {
			assertFalse(Theme.UNKNOWN == eq.getTheme());
			assertFalse(Categorie.UNKNOWN == eq.getCategorie());
			assertFalse(Type.UNKNOWN == eq.getType());
		}
	}

	/**
	 * Vérification de la lecture des attributs d'un parking
	 */
	@Test
	public void testParkingEnclos() {
		Map<Integer, Equipement> map = EquipementManager.getInstance()
				.getMapEquipements();
		Equipement parkingFeydeau = map.get(3549);
		assertEquals("Parc en enclos Feydeau", parkingFeydeau.getNom());
		assertEquals(Theme.DEPLACEMENT, parkingFeydeau.getTheme());
		assertEquals(Categorie.PARKING_ENCLOS, parkingFeydeau.getCategorie());
		assertEquals(null, parkingFeydeau.getType());
		assertEquals(47.211179655323, parkingFeydeau.getLatitude());
		assertEquals(-1.558438729504, parkingFeydeau.getLongitude());

		assertEquals("Allée de l'Ile Gloriette", parkingFeydeau.getAdresse());
		assertEquals("NANTES", parkingFeydeau.getCommune());
		assertEquals("44000", parkingFeydeau.getCodePostal());
	}

	/**
	 * Vérification de la lecture des attributs d'un parking
	 */
	@Test
	public void testParkingPR() {
		Map<Integer, Equipement> map = EquipementManager.getInstance()
				.getMapEquipements();
		Equipement parkingPirmil = map.get(3197);
		assertEquals("Parc relais tram Pirmil", parkingPirmil.getNom());
		assertEquals(Theme.DEPLACEMENT, parkingPirmil.getTheme());
		assertEquals(Categorie.PARKING_RELAIS, parkingPirmil.getCategorie());
		assertEquals(Type.LIBRE, parkingPirmil.getType());
		assertEquals(47.197358677638, parkingPirmil.getLatitude());
		assertEquals(-1.541533594554, parkingPirmil.getLongitude());

		assertEquals("Rue Esnoult des Châtelets", parkingPirmil.getAdresse());
		assertEquals("NANTES", parkingPirmil.getCommune());
		assertEquals("44200", parkingPirmil.getCodePostal());
	}
	
	/**
	 * Vérification de la lecture des attributs d'un parking
	 */
	@Test
	public void testParkingOuvrage() {
		Map<Integer, Equipement> map = EquipementManager.getInstance()
				.getMapEquipements();
		Equipement parkingPirmil = map.get(677);
		assertEquals("Parking ouvrage Commerce", parkingPirmil.getNom());
		assertEquals(Theme.DEPLACEMENT, parkingPirmil.getTheme());
		assertEquals(Categorie.PARKING, parkingPirmil.getCategorie());
		assertEquals(Type.SOUTERRAIN, parkingPirmil.getType());
		assertEquals(47.213120285802, parkingPirmil.getLatitude());
		assertEquals(-1.55771321969, parkingPirmil.getLongitude());

		assertEquals("Place du Commerce", parkingPirmil.getAdresse());
		assertEquals("NANTES", parkingPirmil.getCommune());
		assertEquals("44000", parkingPirmil.getCodePostal());
	}
}
