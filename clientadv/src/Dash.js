import React from 'react'
import { useNavigate } from 'react-router-dom'

const Dash = () => {
    const navigate = useNavigate()
     const   clickFunc=()=>{
            navigate("login")
    }
  return (<>
  gggg
    <button onClick={clickFunc}>enter</button>
    </>
  )
}

export default Dash