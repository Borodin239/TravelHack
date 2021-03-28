import './Auth.css';
import React from "react";
import axios from "axios";
import * as qs from "querystring";
import {Checkbox} from "@material-ui/core";
import CheckboxesGroup from "./Checkbox/Checkbox";

class Auth extends React.Component {
    constructor(props) {
        super(props);
        this.state = {email: '', password: ''};

        this.handleEmailChange = this.handleEmailChange.bind(this);
        this.handlePasswordChange = this.handlePasswordChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleEmailChange(event) {
        this.setState({email: event.target.value, password: this.state.password});
    }

    handlePasswordChange(event) {
        this.setState({email: this.state.email, password: event.target.value});
    }

    handleSubmit(event) {
        const clientId = "clientapp";
        const clientSecret = "123456";

        const authorizationBasic = window.btoa(clientId + ':' + clientSecret);

        const data = qs.stringify({
            grant_type: 'password',
            username: this.state.email,
            password: this.state.password
        })
        axios.post('http://localhost:8081/oauth/token', data, {
            headers: {
                'Authorization': 'Basic ' + authorizationBasic,
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        }).then(res => {
            // this.setState({token: res.data})
            return res.data;
        })
        event.preventDefault();
    }

    render() {
        if (this.state.token === undefined)
            return (
                <div className="row">
                    <div className="form">
                        <div className="brand-title-super">Authorisation</div>
                        <form onSubmit={this.handleSubmit}>
                            <div className="push-md-top"/>
                            <div className="form-group"><label className="form-group__label">Email</label>
                                <div className="form-group__control "><input name="username" id="username" type="text"
                                                                             className="form-control"
                                                                             value={this.state.email}
                                                                             onChange={this.handleEmailChange}/></div>
                            </div>
                            <div className="push-md-top"/>
                            <div className="form-group"><label htmlFor="username"
                                                               className="form-group__label">Password</label>
                                <div className="form-group__control "><input name="username" id="username" type="text"
                                                                             className="form-control"
                                                                             value={this.state.password}
                                                                             onChange={this.handlePasswordChange}/>
                                </div>
                            </div>
                            <a className="link-underline font-size-small" href="/reset-password">Forgot your
                                password?</a>
                            <div className="push-md-top"/>
                            <button type="submit" id="auth_ok" className={"btn btn--primary auth-btn"}>Log in</button>
                            <div className="push-md-top"/>
                            <div className="push-lg-top">Don't have an account? <a
                                className="link-underline font-size-small" href="/signup">Sign up</a></div>
                            {/*<div className="auth-hr">*/}
                            {/*    <div className="auth-hr__text">or</div>*/}
                            {/*</div>*/}
                            {/*<div className="auth-social push-lg-top"><a*/}
                            {/*    href="https://api.russpass.ru/sso/oauth2/authorize/apple?redirect_uri=https://russpass.ru/callback/oauth"*/}
                            {/*    className="social-btn"*/}
                            {/*    style={{backgroundImage: "/static/media/social-apple.2c482fb4.svg"}}>&nbsp;</a>*/}
                            {/*</div>*/}
                        </form>
                    </div>
                </div>
            );
        else
            return (
                <CheckboxesGroup/>
            );
    }
}

export default Auth;
