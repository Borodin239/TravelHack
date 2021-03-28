import React from 'react';
import './Checkbox.css';
import {makeStyles} from '@material-ui/core/styles';
import FormLabel from '@material-ui/core/FormLabel';
import FormControl from '@material-ui/core/FormControl';
import FormGroup from '@material-ui/core/FormGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormHelperText from '@material-ui/core/FormHelperText';
import Checkbox from '@material-ui/core/Checkbox';

const useStyles = makeStyles((theme) => ({
    root: {
        // display: 'flex',
    },
    formControl: {
        margin: theme.spacing(3),
    },
}));

export default function CheckboxesGroup() {
    const classes = useStyles();
    const [state, setState] = React.useState({
        firstName: true,
        lastName: false,
        passport: false,
    });

    const handleChange = (event) => {
        setState({...state, [event.target.name]: event.target.checked});
    };

    const onSubmit = (event) => {
        let bitmask = 0;
        if (state.firstName) {
            bitmask |= (1 << 0)
        }
        if (state.lastName) {
            bitmask |= (1 << 1)
        }
        if (state.passport) {
            bitmask |= (1 << 2)
        }
        console.log(bitmask);
        event.preventDefault();
    }

    return (
        <div className={classes.root}>
            <FormControl component="fieldset" className="{classes.formControl} form">
                <FormLabel component="legend">Choose data you want to share</FormLabel>
                <FormGroup>
                    <FormControlLabel
                        control={<Checkbox onChange={handleChange} name="firstName"/>}
                        label="First Name"
                    />
                    <FormControlLabel
                        control={<Checkbox onChange={handleChange} name="lastName"/>}
                        label="Last Name"
                    />
                    <FormControlLabel
                        control={<Checkbox onChange={handleChange} name="passport"/>}
                        label="Passport"
                    />
                </FormGroup>
                <button type="submit" className={"btn btn--primary auth-btn"} onClick={onSubmit}>Submit</button>
            </FormControl>
        </div>
    );
}
