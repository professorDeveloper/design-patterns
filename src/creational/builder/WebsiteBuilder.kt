package creational.builder


abstract class WebsiteBuilder {
    var website: Website? = null

    fun createWebsite(): WebsiteBuilder {
        website = Website()
        return this
    }

    abstract fun buildName(): WebsiteBuilder

    abstract fun buildCms(): WebsiteBuilder

    abstract fun buildPrice(): WebsiteBuilder
}