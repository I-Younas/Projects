import React from "react"
import { AppBar, Toolbar, Typography } from '@material-ui/core'
import { makeStyles } from "@material-ui/core/styles"
import { Link } from "react-router-dom"

/* returns the styles*/
const useStyles = makeStyles((theme) => ({
    AppBar: {
        backgroundColor: 'black'
    },
    link: {
        textdecoration: 'none'
    },
    title: {
        cursor: 'pointer', /* turns the cursor to a pointer when we're hovering over the title*/
        color: 'white',
        fontSize: 'h6'
    }
} )) 

function AppNavigator() {
    const classes =useStyles()
    return (
      <AppBar className={classes.AppBar} position="fixed" variant="h6">
        <Toolbar>
            <Link to="/" className={classes.link}>
                <Typography className={classes.title}>Pokedex</Typography>
            </Link>
        </Toolbar>
      </AppBar>
     
    );
  }
  
  export default AppNavigator; 