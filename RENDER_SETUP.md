# Render Web Service Setup

This guide helps you create your backend web service on Render and connect it to PostgreSQL.

## Prerequisites

- Your GitHub repo is pushed: <https://github.com/chamrongraksa/CI-CD-homework>
- Backend GHCR workflow has run at least once and successfully pushed:
  `ghcr.io/chamrongraksa/cicd-homework-backend:latest`

## Option A (Recommended): Create with Blueprint (`render.yaml`)

1. Open Render dashboard.
2. Click **New** -> **Blueprint**.
3. Connect/select repository: `chamrongraksa/CI-CD-homework`.
4. Render will detect `render.yaml` and show resources to create:
   - Web service: `cicd-homework-backend`
   - PostgreSQL: `cicd-homework-db`
5. Click **Apply** / **Create**.

After it creates resources:

6. Open the web service and copy the public URL.
7. Test endpoint:
   - `GET <your-render-url>/api/health`

## Option B: Manual UI Creation

### 1) Create PostgreSQL

1. In Render: **New** -> **PostgreSQL**.
2. Name: `cicd-homework-db`.
3. Plan: free.
4. Create database.

### 2) Create Web Service from Image (GHCR)

1. In Render: **New** -> **Web Service**.
2. Choose **Deploy an existing image from a registry**.
3. Image URL:
   `ghcr.io/chamrongraksa/cicd-homework-backend:latest`
4. Name: `cicd-homework-backend`.
5. Plan: free.

If GHCR image is private:

- Either make GHCR package public.
- Or provide registry credentials in Render:
  - username: your GitHub username
  - password: GitHub PAT with `read:packages`

### 3) Set Environment Variables on Web Service

- `SPRING_DATASOURCE_URL` = PostgreSQL External Database URL (from Render DB info)
- `SPRING_DATASOURCE_USERNAME` = PostgreSQL username
- `SPRING_DATASOURCE_PASSWORD` = PostgreSQL password
- `SPRING_DATASOURCE_DRIVER_CLASS_NAME` = `org.postgresql.Driver`
- `SPRING_JPA_DATABASE_PLATFORM` = `org.hibernate.dialect.PostgreSQLDialect`

Save and deploy.

## Deploy Hook for Bonus Workflow

1. Open Render web service -> **Settings**.
2. Find **Deploy Hook** and create one.
3. Copy URL.
4. In GitHub repo secrets, add:
   - `RENDER_DEPLOY_HOOK_URL` = copied hook URL

## Verify Endpoints

- `GET /api/health`
- `GET /api/messages`
- `POST /api/messages`

Example POST body:

```json
{
  "content": "hello from render"
}
```
