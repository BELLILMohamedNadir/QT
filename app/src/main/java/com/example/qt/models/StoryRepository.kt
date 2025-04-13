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
        val INQUIETUDE = "Inquiétude"
        val ECLATE_RIRE = " éclata de rire"
        val TALKING = "Talking"
        val HONTEUX = "honteux"
        val LÉGER = "léger"
        private val POINTS = "................."

        val storiesFR = mutableListOf(
            Story(
                title = "Le Loup Émotif",
                content = listOf(
                    "Il était une fois un loup qui vivait dans une belle forêt, entouré de tous ses amis. Il s’appelait Loup. Mais ce loup avait un souci : il était trop émotif$POINTS" to TALKING,
                    "Jouyeux$POINTS" to JOIE,
                    "faché$POINTS" to COLERE,
                    "triste$POINTS" to TRISTESSE,
                    "éxcité$POINTS" to EXCITATION,
                    "il changeait d’humeur à cent à l’heure !$POINTS" to TALKING,
                    "Ainsi, quand Loup était d’humeur$POINTS" to TALKING,
                    "joyeuse$POINTS" to JOIE,
                    "il sifflotait, le cœur léger, faisait des blagues, parlait aux arbres… Il était plein d’énergie et débordait d’idées pour s’amuser !$POINTS" +
                            "Cependant, si quelque chose le$POINTS" to TALKING,
                    "contrariait $POINTS" to COLERE,
                    " Il se renfrognait, explosait, et envoyait tout le monde balader !$POINTS" to TALKING,
                    "Tu dois apprendre à te calmer, Loup, lui dit un jour Maître Hibou, excédé. Tu nous donnes le tournis !$POINTS" to TALKING,
                    " Apprendre à me calmer ? Mais pourquoi ? demanda Loup.$POINTS" to TALKING,
                    "Pour être plus serein ! Mais ne t’inquiète pas, nous allons t’aider… On commence demain !$POINTS" to TALKING,
                    "Le lendemain, Loup se rendit chez son ami.$POINTS" to TALKING,
                    "Pour contrôler tes émotions, le yoga, c’est parfait ! déclara Maître Hibou. Respire calmement et fais le vide en toi.$POINTS" to TALKING,
                    "Maître Hibou enchaîna les positions : lotus, montagne… et Loup essaya de l’imiter. Ouh là là ! Ce n’était pas facile, mais qu’est-ce que c’était rigolo ! N’y tenant plus, Loup$POINTS" to TALKING,
                    " éclata de rire$POINTS" to ECLATE_RIRE,
                    "On dirait que le yoga ne fonctionne pas avec toi, soupira Maître Hibou.$POINTS" to TALKING,
                    "À l’extérieur, Alfred attendait Loup de pied ferme.$POINTS" to TALKING,
                    "Rien de tel que le sport pour se défouler, dit-il. Je t’ai préparé un parcours spécial Loup excité. Prêt ?$POINTS" to TALKING,
                    "Et il fila comme une fusée. Derrière lui, Loup courait, sautait, rampait…$POINTS" to TALKING,
                    "Alfred s’arrêta au pied d’un arbre immense.$POINTS" to TALKING,
                    "On se retrouve en haut ! cria-t-il en disparaissant dans les feuillages.$POINTS" to TALKING,
                    "Arrivé au sommet, Loup regarda en bas… Sa gorge se serra, son cœur se mit à cogner dans sa poitrine, ses jambes à trembler.$POINTS" to TALKING,
                    "Alfred, j’ai $POINTS" to TALKING,
                    "peur !$POINTS" to PEUR,
                    " paniqua-t-il. Je vais tomber !$POINTS" to TALKING,
                    "Calme-toi, Loup, je suis avec toi. On va redescendre ensemble, doucement.$POINTS" to TALKING,
                    "Loup prit une grande inspiration et, tout tremblant, il redescendit.$POINTS" to TALKING,
                    "Tu as vaincu ta peur, tu peux être fier de toi ! le félicita Alfred.$POINTS" to TALKING,
                    "Loup sourit : ah ça oui, il était $POINTS" to TALKING,
                    "fier$POINTS" to FIERTE,
                    "de lui !$POINTS" to TALKING,
                    "Tout ceci m’a mis en appétit, se dit Loup. Cela tombait bien : Gros Louis l’attendait chez lui.\n" +
                            "Les pattes pleines de farine, Gros Louis était avec Louve dans la cuisine.\n" to TALKING,
                    "Ils ont l’air de bien s’amuser tous les deux…, pensa Loup,$POINTS" to TALKING,
                    "jaloux$POINTS" to JALOUSIE,
                    "Salut Loup ! fit Gros Louis. Aujourd’hui, on prépare des macarons. Pour réussir ces gâteaux, il faut être très, très patient. Tiens, c’est un bon exercice pour toi, n’est-ce pas ?" to TALKING,
                    "À ces mots, Louve éclata de rire.\n" +
                            "Loup sentit la moutarde lui monter au nez. Il devint tout rouge, tapa du pied et explosa :\n" +
                            "— C’est ça, moquez-vous de moi ! hurla-t-il, très en$POINTS" to TALKING,
                    "colère$POINTS" to COLERE,
                    "Je m’en fiche ! De toute façon, je n’ai pas envie de faire des gâteaux idiots avec des idiots !\n" +
                            "Loup s’en alla, grommelant dans sa barbe et donnant des coups de patte dans les arbres.\n" +
                            "Peu à peu, Loup ralentit son allure, pour finir par se traîner comme un escargot, le cœur lourd. Une larme roula sur sa joue.\n" +
                            "— Je n’aurais pas dû m’énerver, renifla-t-il. Louve ne m’aimera plus jamais… Comme je suis \n $POINTS" to TALKING,
                    "triste$POINTS" to TRISTESSE,
                    "Mais, qu’est-ce qui arrive à mon super copain ? fit alors une voix derrière lui.\n" +
                            "C’était Demoiselle Yéti. Elle lui fit un gros câlin, puis elle dit :\n" +
                            "— Ce qui est fait est fait. Maintenant, il faut réparer ta bêtise ! Va voir Gros Louis et Louve, et excuse-toi. Tu te sentiras beaucoup mieux après.\n" +
                            "— Et si Louve ne veut pas me pardonner ? fit Loup,\n$POINTS" to TALKING,
                    "inquiet$POINTS" to INQUIETUDE,
                    "Qui ne tente rien n’a rien, répondit Demoiselle Yéti. Allez, file !\n" +
                            "Tout $POINTS" to TALKING,
                    "honteux$POINTS" to HONTEUX,
                    " Loup retourna frapper à la porte de Gros Louis.\n" +
                            "— Je vous demande pardon, les amis, fit-il. Je ne pensais pas ce que j’ai dit. Ce n’était pas gentil.\n" +
                            "— Excuses acceptées, sourit Louve.\n" +
                            "Loup et Louve se regardèrent, des cœurs plein les yeux. Loup leva ses pattes : il se sentait $POINTS" to TALKING,
                    "léger$POINTS" to LÉGER,
                    "léger$POINTS" to LÉGER,
                    "léger$POINTS" to LÉGER,
                    "! Et… il était affamé ! $POINTS" to TALKING,
                    "À table, mes amis, les macarons sont prêts ! $POINTS" to TALKING

                )
            ),
            Story(
                title = "Le Lapin Écoute",
                content = listOf(
                    "Taylor construisit une tour magnifique avec des blocs. Il était très $POINTS" to TALKING,
                    "fier $POINTS" to FIERTE,
                    "de sa création. $POINTS" to TALKING,
                    "Mais soudain,$POINTS" to TALKING,
                    "un groupe d'oiseaux passa et détruisit tout. Taylor se sentit $POINTS" to TALKING,
                    "triste$POINTS" to TRISTESSE,
                    "et dévasté. $POINTS" to TALKING,
                    "Un poulet proposa de parler de ce qui s'était passé, mais Taylor était trop $POINTS" to TALKING,
                    "en colère$POINTS" to COLERE,
                    "pour écouter.$POINTS" to TALKING,
                    "Un ours suggéra de crier pour se défouler, mais cela ne fonctionna pas. Taylor se sentit toujours $POINTS" to TALKING,
                    "triste$POINTS" to TRISTESSE,
                    "et seul.$POINTS" to TALKING,
                    "Puis le lapin arriva et resta silencieux à ses côtés. Taylor sentit une chaleur réconfortante et commença à parler,$POINTS" to TALKING,
                    "puis à rire.$POINTS" to JOIE,
                    "Enfin, il décida de reconstruire sa tour avec le soutien du lapin.$POINTS" to TALKING
                )
            ),
            Story(
                title = "L'Oie Grincheuse",
                content = listOf(
                    "Il était une fois une oie nommée Grouchy Goose qui était toujours $POINTS" to TALKING,
                    "grincheuse$POINTS" to COLERE,
                    "Elle criait sur les autres oies et marchait en frappant ses pattes au sol.$POINTS" to TALKING,
                    "Un jour, elle vit son reflet dans l'eau et se rendit compte qu'elle avait l'air très$POINTS" to TALKING,
                    "honteuse$POINTS" to HONTEUX,
                    "Cela la rendit triste$POINTS" to TRISTESSE,
                    "car elle comprit pourquoi les autres oies ne voulaient pas jouer avec elle.$POINTS" to TALKING,
                    "Avec l'aide d'une amie,$POINTS" to TALKING,
                    "elle apprit à sourire et à être plus joyeuse$POINTS" to JOIE,
                    "Finalement, elle devint amie avec les autres oies et se sentit$POINTS" to TALKING,
                    "fière$POINTS" to FIERTE
                )
            ),
            Story(
                title = "Ruby et son Souci",
                content = listOf(
                    "Ruby était une petite fille heureuse qui aimait explorer.$POINTS" to JOIE,
                    "Mais un jour $POINTS" to TALKING,
                    "elle trouva un petit souci.$POINTS" to INQUIETUDE,
                    "Le souci grandit chaque jour et$POINTS" to TALKING,
                    "devint énorme, remplissant ses pensées.$POINTS" to PEUR,
                    "Ruby ne pouvait plus profiter des choses qu'elle aimait et se sentait très$POINTS" to TALKING,
                    "triste$POINTS" to TRISTESSE,
                    "Un jour, elle rencontra un garçon avec son propre souci. Ensemble, ils parlèrent de leurs soucis$POINTS" to TALKING,
                    "et ceux-ci commencèrent à rétrécir.$POINTS" to JOIE,
                    "Ruby retrouva sa joie de vivre et comprit que partager ses émotions pouvait les alléger.$POINTS" to FIERTE,
                )
            )
        )

        val storiesEN = mutableListOf(
            Story(
                title = "The Emotional Wolf",
                content = listOf(
                    "Once upon a time, there was a wolf who lived in a beautiful forest surrounded by friends. His name was Wolf. But Wolf had a problem: he was too emotional!$POINTS" to TALKING,
                    "Happy$POINTS" to JOIE,
                    "angry$POINTS" to COLERE,
                    "sad$POINTS" to TRISTESSE,
                    "excited$POINTS" to EXCITATION,
                    ", his mood changed constantly!$POINTS" to TALKING,
                    "When Wolf felt$POINTS" to TALKING,
                    "joyful$POINTS" to JOIE,
                    ", he whistled, joked, and talked with the trees. He was full of energy and bursting with ideas for fun! But if something$POINTS" to TALKING,
                    "upsets him, $POINTS" to COLERE,
                    ", he would frown, explode, and push everyone away!$POINTS" to TALKING,
                    "One day, Master Owl said: You need to learn how to calm down, Wolf. You're making us dizzy!$POINTS" to TALKING,
                    "Learn to calm down? But why? asked Wolf.$POINTS" to TALKING,
                    "To be more serene! Don’t worry, we’ll help you… We’ll start tomorrow!$POINTS" to TALKING,
                    "The next day, Wolf visited Master Owl.$POINTS" to TALKING,
                    "To control your emotions, yoga is perfect! declared Master Owl. Breathe calmly and clear your mind.$POINTS" to TALKING,
                    "Master Owl demonstrated poses: lotus, mountain… and Wolf tried to imitate him. Oh dear! It wasn’t easy, but it was so funny! Unable to hold back, Wolf$POINTS" to TALKING,
                    "burst into laughter$POINTS" to ECLATE_RIRE,
                    ". Looks like yoga doesn’t work for you, sighed Master Owl.$POINTS" to TALKING,
                    "Outside, Alfred was waiting for Wolf.$POINTS" to TALKING,
                    "Nothing beats exercise for letting off steam, he said. I’ve prepared a special course for an excited wolf. Ready?$POINTS" to TALKING,
                    "And off he went like a rocket. Behind him, Wolf ran, jumped, crawled…$POINTS" to TALKING,
                    "Alfred stopped at the base of a huge tree.$POINTS" to TALKING,
                    "See you at the top! he shouted as he disappeared into the leaves.$POINTS" to TALKING,
                    "At the summit, Wolf looked down… His throat tightened, his heart pounded in his chest, his legs trembled.$POINTS" to TALKING,
                    "Alfred, I’m scared!$POINTS" to PEUR,
                    ", he panicked. I’m going to fall!$POINTS" to PEUR,
                    "Calm down, Wolf; I’m here with you. We’ll go down together, slowly.$POINTS" to TALKING,
                    "Wolf took a deep breath and trembling all over, climbed down.$POINTS" to TALKING,
                    "You conquered your fear; you can be proud of yourself! Alfred congratulated him.$POINTS" to TALKING,
                    "Wolf smiled: oh yes, he was proud.$POINTS" to FIERTE,
                    ". All this made me hungry, thought Wolf. Luckily: Big Louis was waiting for him at home.$POINTS" to TALKING,
                    "With paws full of flour, Big Louis was in the kitchen with She-Wolf.$POINTS" to TALKING,
                    "They look like they’re having fun together…,$POINTS" to TALKING,
                    "thought Wolf,$POINTS" to JALOUSIE,
                    ". Hi Wolf! said Big Louis. Today we’re making macarons. To make these treats successfully, you need lots and lots of patience. This will be good practice for you! said Big Louis.$POINTS" to TALKING,
                    "She-Wolf burst into laughter.$POINTS" to ECLATE_RIRE,
                )
            ),
            Story(
                title = "Grouchy Goose",
                content = listOf(
                    "Once upon a time, there was a goose named Grouchy Goose who was always $POINTS" to TALKING,
                    "grumpy$POINTS" to COLERE,
                    ". She yelled at the other geese and stomped her feet on the ground.$POINTS" to TALKING,
                    "One day, she saw her reflection in the water and realized she looked very$POINTS" to TALKING,
                    "ashamed$POINTS" to HONTEUX,
                    ". This made her sad$POINTS" to TRISTESSE,
                    "because she understood why the other geese didn’t want to play with her.$POINTS" to TALKING,
                    "With the help of a friend,$POINTS" to TALKING,
                    "she learned how to smile and be more joyful$POINTS" to JOIE,
                    ". Eventually, she became friends with the other geese and felt$POINTS" to TALKING,
                    "proud$POINTS" to FIERTE
                )
            ),
            Story(
                title = "The Rabbit Listened",
                content = listOf(
                    "Taylor built a magnificent tower with blocks. He was very $POINTS" to TALKING,
                    "proud $POINTS" to FIERTE,
                    "of his creation.$POINTS" to TALKING,
                    "But suddenly,$POINTS" to TALKING,
                    "a flock of birds flew by and knocked it all down. Taylor felt$POINTS" to TALKING,
                    "sad$POINTS" to TRISTESSE,
                    "and devastated.$POINTS" to TALKING,
                    "A chicken suggested talking about what had happened, but Taylor was too$POINTS" to TALKING,
                    "angry$POINTS" to COLERE,
                    "to listen.$POINTS" to TALKING,
                    "A bear suggested yelling it out, but that didn’t help. Taylor still felt$POINTS" to TALKING,
                    "sad$POINTS" to TRISTESSE,
                    "and alone.$POINTS" to TALKING,
                    "Then the rabbit came and sat silently beside him. Taylor felt a comforting warmth and began to talk,$POINTS" to TALKING,
                    "then laugh.$POINTS" to JOIE,
                    "Finally, he decided to rebuild his tower with the rabbit’s support.$POINTS" to TALKING
                )
            ),
            Story(
                title = "Ruby Finds a Worry",
                content = listOf(
                    "Ruby was a happy little girl who loved exploring.$POINTS" to JOIE,
                    "But one day$POINTS" to TALKING,
                    "she found a small worry.$POINTS" to INQUIETUDE,
                    "The worry grew bigger every day and$POINTS" to TALKING,
                    "became enormous, filling her thoughts.$POINTS" to PEUR,
                    "Ruby could no longer enjoy the things she loved and felt very$POINTS" to TALKING,
                    "sad$POINTS" to TRISTESSE,
                    "One day, she met a boy with his own worry. Together, they talked about their worries$POINTS" to TALKING,
                    "and they began to shrink.$POINTS" to JOIE,
                    "Ruby regained her joy and realized that sharing her feelings made them lighter.$POINTS" to FIERTE
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
