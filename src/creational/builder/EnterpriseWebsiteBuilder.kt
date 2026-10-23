package creational.builder


class EnterpriseWebsiteBuilder : WebsiteBuilder() {
    override fun buildName(): WebsiteBuilder {
        website?.setName("Enterprise Website")
        return this
    }

    override fun buildCms():WebsiteBuilder {
        website?.setCms(Cms.WORDPRESS)
        return this
    }

    override fun buildPrice(): WebsiteBuilder {
        website?.setPrice(1000)
        return this
    }

}