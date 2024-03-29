###### Must run 'ng build -c production' to build at local before creating image ######

######  Use NgInx alpine image  ###### 
FROM nginx:stable-alpine

# Remove default nginx website
RUN rm -rf /usr/share/nginx/html/*

# Remove default nginx configuration
RUN rm /etc/nginx/conf.d/default.conf

# Copy nginx config file for resolving 404 error when refreshing page
COPY ./nginx/nginx.conf /etc/nginx/nginx.conf

# Copy dist folder fro build stage to nginx public folder
COPY ./dist/web-front /usr/share/nginx/html

# Start NgInx service
CMD ["nginx", "-g", "daemon off;"]