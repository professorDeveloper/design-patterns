package creational.builder


class SimpleWebsiteBuilder : WebsiteBuilder() {
    override fun buildName():WebsiteBuilder {
        website!!.setName("Simple Website Builder")
        return this
    }

    override fun buildCms() :WebsiteBuilder{
        website!!.setCms(Cms.TILDA)
        return this
    }

    override fun buildPrice():WebsiteBuilder {
        website!!.setPrice(500)
        return this
    }
}