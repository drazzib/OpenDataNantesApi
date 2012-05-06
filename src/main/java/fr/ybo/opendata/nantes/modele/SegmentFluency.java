package fr.ybo.opendata.nantes.modele;

import fr.ybo.opendata.nantes.sax.BaliseData;
import fr.ybo.opendata.nantes.sax.BaliseType;
import fr.ybo.opendata.nantes.sax.BaliseXml;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 * User: nicolasguillot
 * Date: 05/05/12
 * Time: 15:19
 */
@BaliseData("Troncon")
public class SegmentFluency implements Serializable {
    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(SegmentFluency.class.getSimpleName());

    /**
     * Serial.
     */
    private static final long serialVersionUID = -1L;

    /**
    * Identifiant du tronçon
    * */
    private int id;

    private int colorId;

    public int getId() {
        return id;
    }

    @BaliseXml(name = "Id", type = BaliseType.INTEGER)
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Code couleur permettant de définir la fluidité du trafic routier
     0 : violet
     1 : gris (sans indication)
     2 : blanc (données manquantes ou erronées)
     3 : vert (fluide)
     4 : jaune (dense)
     5 : orange (saturé)
     6 : rouge (bloqué)
     * @return
     **/
    public int getColorId() {
        return colorId;
    }

    @BaliseXml(name = "Couleur_TP", type = BaliseType.INTEGER)
    public void setColorId(int colorId) {
        this.colorId = colorId;
    }
}
