package com.example.forcaerp20.DashboardPage.approveFragment

data class ListApproved(
    var TypeApprovDocument: String = "",
    var NameApprovDocument: String = "",
    var NumberApprovDocument: Int = 0,
    var BusinessApprovDocument: String = "",
    var NominalApprovDocument: String = "",
    var DateApprovDocument: String = "",
    var HistoryApprovDocument: String = "",
    var DescriptionApprovDocument: String = "",
    var StatusApprovDocument: String = ""
){
companion object{
    var sortByNameAZ = Comparator<ListApproved> { o1, o2 -> o1.NameApprovDocument.compareTo(o2.NameApprovDocument) }

    var sortByNameZA = Comparator<ListApproved> { o1, o2 -> o2.NameApprovDocument.compareTo(o1.NameApprovDocument) }
}
}
