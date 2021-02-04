import processing.core.PApplet

object Sketch: PApplet(){
    init {
        setSize(1004, 591)
        runSketch()
    }

    override fun setup(){
        val baseImage = loadImage("data/lakme_coupon.jpeg")
        val font = createFont("data/Raleway-Medium.ttf", 32f, false, "0123456789".toCharArray())
        for(couponCode in 1..1){
            println("Generating coupon $couponCode")
            val coupon = createGraphics(baseImage.width, baseImage.height)
            coupon.beginDraw()
            coupon.noStroke()
            coupon.textFont(font)
            coupon.image(baseImage, 0f, 0f)
            coupon.fill(0f, 0f, 0f)
            coupon.rect(400f, 500f, 120f, 40f)
            coupon.fill(159f, 32f, 99f)
            coupon.textSize(32f)
            coupon.stroke(159f, 32f, 99f)
            coupon.strokeWeight(16f)
            val code = String.format("%3d", couponCode).replace(' ', '0')
            for(i in 0..2){
                coupon.text(code[i],412f + i * 30, 530f)
            }
            coupon.endDraw()
            image(coupon, 0f, 0f)
//            coupon.save("data/output/coupon_$code.jpeg")
        }
    }
}

fun main(){
    Sketch.start()
}