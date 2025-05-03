const express=require('express')
const bodyParser=require('body-parser')
const app=express()//create rest object
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({extended:true}))
app.use(bodyParser.raw())
app.use(bodyParser.text())
app.post('/submit',(req,res)=>{
    console.log(req.body)
    res.send('Form submitted successfully!')
})
const port=3000
app.listen(port,()=>{
    console.log(`Server started on port ${port}`)
})