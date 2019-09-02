package ai.rever.explayout.emulatedata

import ai.rever.explayout.model.PersonItem
import androidx.lifecycle.MutableLiveData

var randomNameList = arrayOf("Nicholle Rossignol", "Issac Maisonet", "Maryam Shimp", "Emelia Chilson", "Lorenza Broxton",
        "Luz Seabrooks", "Lily Earnshaw", "Ayanna Zaldivar", "Chantay Lovell", "Jacalyn Boggan", "Teodoro Kimball", "Kathy Begaye", "Nobuko Najar",
        "Yolonda Mccaffery", "Ngoc Trotman", "Regena Teed", "Valentina Hilger", "Derrick Molinari", "Eve Tanouye",
        "Kenyetta Minter", "Asa Bundick", "Rosendo Vanwart", "Sunny Sienkiewicz", "Helen Laguerre", "Caryn Crompton", "Yon Kehrer", "Kennith Twedt",
        "Quincy Mcnear", "Lorrie Heatherington", "Melva Brass", "Mellisa Eno", "Chun Devera", "Vonda Mitcham", "Roselia Uhlman", "Marth Downie",
        "Marianela Lechner", "Tabetha Fondren", "Carie Stelly", "Bernadette Garris", "Kathryne Gertz", "Terisa Paulhus", "Lakiesha Vandenbosch",
        "Jodee Mooneyhan", "Cristina Towle", "Tena Boeck", "Hank Tustin", "Nada Gould", "Raguel Merwin", "Williams Buchan", "Ty Ned",
        "Edelmira Pomerleau", "Amparo Rosol", "Ashley Gaudette", "Bruce Huber", "Miguel Catania", "Dimple Bonnett", "Karma Becenti", "Kris Huhn", "Mohammed Churchill",
        "Jacqui Asher", "Trisha Medley", "Zenaida Wolfgram","Shona Evitt", "Cordell Tu", "Dexter Ehrlich", "Emogene Brewer", "Jacki Raynes",
        "Jolene Dimarco", "Larae Gilmour", "Carmine Strandberg", "Lilliam Poythress", "Priscilla Valerio", "Reiko Muldrow", "Adaline Judkins",
        "Jonelle Cupit", "Hue Loth", "Angelena Fields", "Jaquelyn Bezanson", "Davina Cerezo", "Giovanni Chilcote", "Alberto Boddy", "Marylynn Bressler",
        "Francisca Burchett", "Arla Mcgirt", "Dan Nitti", "Sherry Lehner", "Danae Lenard", "Bernie Halfacre", "Eleonora Peart", "Rhiannon Benz", "Zenobia Isett",
        "Lizbeth Brecht", "Latrice Hamil", "Emmett Douville", "Janice Meinhardt", "Caron Caryl", "Daniele Clubb", "Katrice Altom", "Elba Moises", "Jina Dewald")

fun createRandomPhotoURL(): String{
        val index = (Math.random()*1080).toInt()
        val url = "https://picsum.photos/id/$index/200/300"
        return url
}

val liveDataOne : MutableLiveData<MutableList<PersonItem>> = MutableLiveData()
val liveDataTwo : MutableLiveData<MutableList<PersonItem>> = MutableLiveData()
val liveDataThree : MutableLiveData<MutableList<PersonItem>> = MutableLiveData()