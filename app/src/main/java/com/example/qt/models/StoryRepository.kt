package com.example.qt.models

import com.example.qt.R

class StoryRepository {

    companion object {
        val JOIE = "Joie"
        val COLERE = "Colère"
        val TRISTESSE = "Tristesse"
        val EXCITATION = "Excitation"
        val PEUR = "Peur"
        val FIERTE = "Fierté"
        val JALOUSIE = "Jalousie"
        private val CURIOSITE = "Curiosité"
        private val AMUSEMENT = "Amusement"
        private val ESPOIR = "Espoir"
        private val SOULAGEMENT = "Soulagement"
        private val BONHEUR = "Bonheur"
        private val RÊVERIE = "Rêverie"
        private val INTRIGUE = "Intrigue"
        val INQUIETUDE = "Inquiétude"
        val ECLATE_RIRE = " éclata de rire"
        val TALKING = "Talking"
        val HONTEUX = "honteux"
        val LÉGER = "léger"
        private val POINTS = "................."
        val stories = mutableListOf(
            Story(
                title = "Le Loup Émotif",
                content = listOf(
                    "Il était une fois un loup qui vivait dans une belle forêt, entouré de tous ses amis. Il s’appelait Loup. Mais ce loup avait un souci : il était trop émotif" to TALKING,
                    "Jouyeux$POINTS" to JOIE,
                    "faché$POINTS" to COLERE,
                    "triste$POINTS" to TRISTESSE,
                    "éxcité$POINTS" to EXCITATION,
                    "il changeait d’humeur à cent à l’heure !" to TALKING,
                    "Ainsi, quand Loup était d’humeur" to TALKING,
                    "joyeuse$POINTS" to JOIE,
                    "il sifflotait, le cœur léger, faisait des blagues, parlait aux arbres… Il était plein d’énergie et débordait d’idées pour s’amuser !\n" +
                            "Cependant, si quelque chose le" to TALKING,
                    "contrariait Ah!$POINTS" to COLERE,
                    " Il se renfrognait, explosait, et envoyait tout le monde balader !" to TALKING,
                    "Tu dois apprendre à te calmer, Loup, lui dit un jour Maître Hibou, excédé. Tu nous donnes le tournis !" to TALKING,
                    " Apprendre à me calmer ? Mais pourquoi ? demanda Loup." to TALKING,
                    "Pour être plus serein ! Mais ne t’inquiète pas, nous allons t’aider… On commence demain !" to TALKING,
                    "Le lendemain, Loup se rendit chez son ami." to TALKING,
                    "Pour contrôler tes émotions, le yoga, c’est parfait ! déclara Maître Hibou. Respire calmement et fais le vide en toi." to TALKING,
                    "Maître Hibou enchaîna les positions : lotus, montagne… et Loup essaya de l’imiter. Ouh là là ! Ce n’était pas facile, mais qu’est-ce que c’était rigolo ! N’y tenant plus, Loup" to TALKING,
                    " éclata de rire$POINTS" to ECLATE_RIRE,
                    "On dirait que le yoga ne fonctionne pas avec toi, soupira Maître Hibou." to TALKING,
                    "À l’extérieur, Alfred attendait Loup de pied ferme." to TALKING,
                    "Rien de tel que le sport pour se défouler, dit-il. Je t’ai préparé un parcours spécial Loup excité. Prêt ?" to TALKING,
                    "Et il fila comme une fusée. Derrière lui, Loup courait, sautait, rampait…" to TALKING,
                    "Alfred s’arrêta au pied d’un arbre immense." to TALKING,
                    "On se retrouve en haut ! cria-t-il en disparaissant dans les feuillages." to TALKING,
                    "Arrivé au sommet, Loup regarda en bas… Sa gorge se serra, son cœur se mit à cogner dans sa poitrine, ses jambes à trembler." to TALKING,
                    "Alfred, j’ai " to TALKING,
                    "peur !$POINTS" to PEUR,
                    " paniqua-t-il. Je vais tomber !" to TALKING,
                    "Calme-toi, Loup, je suis avec toi. On va redescendre ensemble, doucement." to TALKING,
                    "Loup prit une grande inspiration et, tout tremblant, il redescendit." to TALKING,
                    "Tu as vaincu ta peur, tu peux être fier de toi ! le félicita Alfred." to TALKING,
                    "Loup sourit : ah ça oui, il était " to TALKING,
                    "fier$POINTS" to FIERTE,
                    "de lui !" to TALKING,
                    "Tout ceci m’a mis en appétit, se dit Loup. Cela tombait bien : Gros Louis l’attendait chez lui.\n" +
                            "Les pattes pleines de farine, Gros Louis était avec Louve dans la cuisine.\n" to TALKING,
                    "Ils ont l’air de bien s’amuser tous les deux…, pensa Loup," to TALKING,
                    "jaloux$POINTS" to JALOUSIE,
                    "Salut Loup ! fit Gros Louis. Aujourd’hui, on prépare des macarons. Pour réussir ces gâteaux, il faut être très, très patient. Tiens, c’est un bon exercice pour toi, n’est-ce pas ?" to TALKING,
                    "À ces mots, Louve éclata de rire.\n" +
                            "Loup sentit la moutarde lui monter au nez. Il devint tout rouge, tapa du pied et explosa :\n" +
                            "— C’est ça, moquez-vous de moi ! hurla-t-il, très en \n" to TALKING,
                    "colère$POINTS" to COLERE,
                    "Je m’en fiche ! De toute façon, je n’ai pas envie de faire des gâteaux idiots avec des idiots !\n" +
                            "Loup s’en alla, grommelant dans sa barbe et donnant des coups de patte dans les arbres.\n" +
                            "Peu à peu, Loup ralentit son allure, pour finir par se traîner comme un escargot, le cœur lourd. Une larme roula sur sa joue.\n" +
                            "— Je n’aurais pas dû m’énerver, renifla-t-il. Louve ne m’aimera plus jamais… Comme je suis \n" to TALKING,
                    "triste$POINTS" to TRISTESSE,
                    "Mais, qu’est-ce qui arrive à mon super copain ? fit alors une voix derrière lui.\n" +
                            "C’était Demoiselle Yéti. Elle lui fit un gros câlin, puis elle dit :\n" +
                            "— Ce qui est fait est fait. Maintenant, il faut réparer ta bêtise ! Va voir Gros Louis et Louve, et excuse-toi. Tu te sentiras beaucoup mieux après.\n" +
                            "— Et si Louve ne veut pas me pardonner ? fit Loup,\n" to TALKING,
                    "inquiet$POINTS" to INQUIETUDE,
                    "Qui ne tente rien n’a rien, répondit Demoiselle Yéti. Allez, file !\n" +
                            "Tout " to TALKING,
                    "honteux$POINTS" to HONTEUX,
                    " Loup retourna frapper à la porte de Gros Louis.\n" +
                            "— Je vous demande pardon, les amis, fit-il. Je ne pensais pas ce que j’ai dit. Ce n’était pas gentil.\n" +
                            "— Excuses acceptées, sourit Louve.\n" +
                            "Loup et Louve se regardèrent, des cœurs plein les yeux. Loup leva ses pattes : il se sentait " to TALKING,
                    "léger$POINTS" to LÉGER,
                    "léger$POINTS" to LÉGER,
                    "léger$POINTS" to LÉGER,
                    "! Et… il était affamé ! " to TALKING,
                    "À table, mes amis, les macarons sont prêts ! " to TALKING

                )
            ),
            Story(
                title = "Le Chat Voyageur",
                content = listOf(
                    "Félix le chat rêvait de voyager." to "Excitation",
                    "Il sauta dans un sac et arriva en ville." to "Peur",
                    "Une boulangère lui donna du lait." to "Soulagement",
                    "Un chien amical l’aida à rentrer chez lui." to "Joie"
                )
            ),
            Story(
                title = "La Fée des Étoiles",
                content = listOf(
                    "Léa, une petite fée, voulait toucher une étoile." to "Rêverie",
                    "Elle vola haut dans le ciel, mais perdit son chemin." to "Inquiétude",
                    "Un hibou sage lui montra la bonne direction." to "Soulagement",
                    "Elle rentra chez elle et brilla de mille feux." to "Joie"
                )
            ),
            Story(
                title = "L'ours et la Lanterne",
                content = listOf(
                    "Un ours trouva une lanterne magique dans la forêt." to "Curiosité",
                    "La lumière l’attira, mais elle commença à s’éteindre." to "Peur",
                    "Il souffla doucement et elle brilla à nouveau." to "Soulagement",
                    "L’ours dansa sous la lumière étoilée." to "Bonheur"
                )
            ),
            Story(
                title = "Le Petit Robot Curieux",
                content = listOf(
                    "Un robot trouva un vieux livre dans une décharge." to "Intrigue",
                    "Il ne comprenait pas les lettres et se sentit perdu." to "Tristesse",
                    "Un enfant lui montra comment lire." to "Espoir",
                    "Le robot découvrit un monde plein d’histoires." to "Joie"
                )
            )
        )

        val backgrounds = mutableListOf(
            R.drawable.background9,
            R.drawable.background8,
            R.drawable.background1,
            R.drawable.background2,
            R.drawable.background3,
            R.drawable.background4,
            R.drawable.background5,
            R.drawable.background6,
            R.drawable.background7
        )
    }
}
