package creational.builder;

class Director() {
    private var builder: WebsiteBuilder? = null

    fun setWebsite(builder: WebsiteBuilder) {
        this.builder = builder
    }

    fun buildWebsite(): Website? {
        if (builder == null) {
            println("Please set the Website builder first.")
            return null
        }
        return builder!!.createWebsite().buildName().buildPrice().buildCms().website
    }
}