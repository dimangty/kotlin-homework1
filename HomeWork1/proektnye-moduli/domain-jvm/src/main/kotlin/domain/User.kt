package domain

data class User(val id: Long, val name: String) {
    init {
        require(id > 0) { "id must be positive" }
    }
}
