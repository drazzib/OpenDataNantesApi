package fr.ybo.opendata.nantes;

import static junit.framework.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;

import fr.ybo.opendata.nantes.modele.Categorie;
import fr.ybo.opendata.nantes.modele.Equipement;
import fr.ybo.opendata.nantes.modele.Theme;
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
	 * Vérification de la lecture des attributs d'un parking
	 */
	@Test
	public void testParkingLoading() {
		Map<Integer, Equipement> map = EquipementManager.getInstance()
				.getMapEquipements();
		Equipement parkingFeydeau = map.get(3549);
		assertEquals("Parking enclos Feydeau", parkingFeydeau.getNom());
		assertEquals(Theme.DEPLACEMENT, parkingFeydeau.getTheme());
		assertEquals(Categorie.PARKING, parkingFeydeau.getCategorie());
		assertEquals(null, parkingFeydeau.getType());
		assertEquals(47.211179655323, parkingFeydeau.getLatitude());
		assertEquals(-1.558438729504, parkingFeydeau.getLongitude());

		assertEquals("Allée de l'Ile Gloriette", parkingFeydeau.getAdresse());
		assertEquals("NANTES", parkingFeydeau.getCommune());
		assertEquals("44000", parkingFeydeau.getCodePostal());
	}
}
