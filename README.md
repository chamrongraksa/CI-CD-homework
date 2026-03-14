# CI/CD Homework Starter

This repository is a ready-to-use starter for the assignment requirements:

- Frontend CI/CD with GitHub Actions -> Vercel
- Backend CI/CD with GitHub Actions + Jib -> GHCR
- Backend deploy on Render with a database-backed endpoint
- Bonus CD workflow to auto-deploy backend to Render after GHCR push

## Project Structure

- `.github/workflows/frontend-vercel.yml`
- `.github/workflows/backend-ghcr.yml`
- `.github/workflows/backend-render-cd.yml` (bonus)
- `frontend/` static site
- `backend/` Spring Boot app (Java 21, Maven, Jib)

## Part 1 - Frontend (Vercel)

### 1) Create Vercel Project

1. Import this GitHub repo into Vercel (or create a Vercel project manually).
2. Keep root directory as `frontend`.

### 2) Add GitHub Secrets

In GitHub repo -> Settings -> Secrets and variables -> Actions, add:

- `VERCEL_TOKEN`
- `VERCEL_ORG_ID`
- `VERCEL_PROJECT_ID`

### 3) Trigger Deployment

Push to `main`. Workflow `Frontend CI/CD - Deploy to Vercel` will run and deploy publicly.

## Part 2 - Backend (GHCR + Render + DB)

### 1) Create a Render PostgreSQL database

In Render, create a PostgreSQL instance and note:

- host
- port
- database name
- username
- password

### 2) Create Render Web Service from GHCR image

1. Create a Render Web Service using image:
   - `ghcr.io/<your-github-username>/cicd-homework-backend:latest`
2. Set environment variables in Render service:

- `PORT` = `10000` (or leave default; Render injects this)
- `SPRING_DATASOURCE_URL` = `jdbc:postgresql://<host>:<port>/<db>`
- `SPRING_DATASOURCE_USERNAME` = `<username>`
- `SPRING_DATASOURCE_PASSWORD` = `<password>`
- `SPRING_DATASOURCE_DRIVER_CLASS_NAME` = `org.postgresql.Driver`
- `SPRING_JPA_DATABASE_PLATFORM` = `org.hibernate.dialect.PostgreSQLDialect`

### 3) GHCR Push Workflow Secrets/Permissions

No PAT is required for this starter when using `GITHUB_TOKEN` in the workflow, but ensure:

- Repository Actions have permission to write packages.

Push to `main`. Workflow `Backend CI - Build & Push to GHCR` will publish:

- `ghcr.io/<your-github-username>/cicd-homework-backend:latest`

### 4) Backend Endpoints

After Render deploy is healthy, test:

- `GET /api/health`
- `GET /api/messages`
- `POST /api/messages` with JSON body: `{ "content": "hello" }`

## Bonus - Auto Deploy Backend to Render

`backend-render-cd.yml` triggers after successful GHCR push workflow and calls Render deploy hook.

Add this GitHub secret:

- `RENDER_DEPLOY_HOOK_URL`

In Render Web Service -> Settings -> Deploy Hook -> copy URL.

## Submission Template

Fill these before submitting:

1. GitHub repo URL(s):
   - `<repo-url>`
2. Live frontend URL (Vercel):
   - `<frontend-url>`
3. Live backend URL + endpoints:
   - `<backend-url>/api/health`
   - `<backend-url>/api/messages`
4. GitHub Actions successful run links:
   - `<frontend-workflow-run-link>`
   - `<backend-ghcr-workflow-run-link>`
   - `<bonus-render-cd-run-link>` (optional)
