package ai.rever.explayout.model

import ai.rever.explayout.emulatedata.createRandomPhotoURL

class PersonItem( var name: String) {

    var id = System.currentTimeMillis()
    var photoUrl = createRandomPhotoURL()
    var meditatingTo: String? = ""
    var breaths: Int? = (Math.random()*1000).toInt()
    var minutes: Int? = (Math.random()*15000).toInt()
    var fieldA: String? = ""
    var filedB: String? = ""
    var fieldC: String? = ""
    var filedD: String? = ""
    var fieldE: String? = ""
    var filedF: String? = ""
    var fieldG: String? = ""
    var filedH: String? = ""
    var fieldI: String? = ""
    var filedJ: String? = ""
    var fieldK: String? = ""
    var filedL: String? = ""
    var fieldM: String? = ""
    var filedN: String? = ""
    var fieldO: String? = ""
    var filedP: String? = ""
    var fieldQ: String? = ""
    var filedR: String? = ""

    var followers: List<PersonItem> = emptyList()
    var following: List<PersonItem> = emptyList()

    var type: Int? = 1

    override fun toString(): String {
        val text = "Name: $name, ID: $id, PhotoURL: $photoUrl Breaths: $breaths Minutes: $minutes "
        return text
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

}