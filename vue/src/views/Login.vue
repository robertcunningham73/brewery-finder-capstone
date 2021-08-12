<template>
<div class="content">
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      /><br>
      <button type="submit">Sign in</button>
      <router-link :to="{ name: 'register' }"><br>Need an account?</router-link>
      <a href=""><br>Forgot password?</a>
      
    </form>
    <div class ="img-login">
      <div class="img-div">
        <img :src="require(`@/assets/beers.jpg`)"/>
      </div>
     </div>
  </div>
</div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>
  button{
  background-color: #335c67;
  border: none;
  color: #EFD6AC;
  padding: 8px 16px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 10px;
  }

  .form-control{
    border-radius: 10px;
  }

  label{
    padding-top: 10px;
    
  }
#login a{
  color: #183A37
}
.img-login{
  display: flex;
  align-content: center;
  justify-content: center;
  margin: 0 auto;
  padding-top: 10px;
}

.img-div {
  max-width: 100%;
}
  
</style>
