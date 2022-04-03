package com.example.forcaerp20.DashboardPage.pendingFragment

data class ListPending(
    var TypePendingDocument: String = "",
    var NamePendingDocument: String = "",
    var NumberPendingDocument: Int = 0,
    var BusinessPendingDocument: String = "",
    var NominalPendingDocument: String = "",
    var DatePendingDocument: String = "",
    var HistoryPendingDocument: String = "",
    var DescriptionPendingDocument: String = "",
    var StatusPendingDocument: String = ""

){
companion object{
    var sortByNameAZ = Comparator<ListPending> { o1, o2 -> o1.NamePendingDocument.compareTo(o2.NamePendingDocument) }

    var sortByNameZA = Comparator<ListPending> { o1, o2 -> o2.NamePendingDocument.compareTo(o1.NamePendingDocument) }
}
}
